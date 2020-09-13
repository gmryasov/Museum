package com.example.virtualroom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.virtualroom.R;

import java.io.IOException;

public class MusicActivity extends FragmentActivity {

    Button play, minus15, plus15, backy;
    TextView start, finish, texting;
    MediaPlayer mediaPlayer;
    SeekBar track, volume;
    int elapsedTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        play = (Button) findViewById(R.id.but);
        minus15 = (Button) findViewById(R.id.minus15);
        plus15 = (Button) findViewById(R.id.plus15);
        start = (TextView) findViewById(R.id.start);
        backy = (Button) findViewById(R.id.backy);
        texting = (TextView) findViewById(R.id.texting);
        finish = (TextView) findViewById(R.id.end);
        backy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Intent intent = getIntent();
        String nameOfSearch = intent.getExtras().getString("path");
        texting.setText(intent.getExtras().getString("text"));
        mediaPlayer = MediaPlayer.create(this, Uri.parse(nameOfSearch));
        mediaPlayer.setLooping(true);
        mediaPlayer.seekTo(0);
        mediaPlayer.setVolume(0.5f, 0.5f);
        elapsedTime = mediaPlayer.getDuration();

        track = (SeekBar) findViewById(R.id.seek);
        track.setMax(elapsedTime);

        track.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b) {
                    mediaPlayer.seekTo(i);
                    track.setProgress(i);

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        volume = (SeekBar) findViewById(R.id.volume);
        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                float volumeNum = i / 100f;
                mediaPlayer.setVolume(volumeNum, volumeNum);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mediaPlayer != null) {
                    try {


                        Message msg = new Message();
                        msg.what = mediaPlayer.getCurrentPosition();
                        handler.sendMessage(msg);
                        Thread.sleep(1000);
                    } catch (InterruptedException e ) {

                    }
                }
            }
        }).start();

        minus15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 5000);
            }
        });

        plus15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 5000);
            }
        });




    }

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int currenPosition = msg.what;

            String time = createTimeLabel(currenPosition);
            start.setText(time);
            String remainingtime  = createTimeLabel(elapsedTime - currenPosition);
            finish.setText("- "+ remainingtime);

        }
    };

    private String createTimeLabel(int currenPosition) {
        String timeLabel = "";
        int min = currenPosition /  1000 / 60;
        int sec = currenPosition / 1000 % 60;
        timeLabel = min+":";
        if (sec < 10 ) timeLabel +="0";
        timeLabel+=sec;

        return timeLabel;

    }


    public void PlayBtnClick(View view) {
        if(!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        } else {
            mediaPlayer.pause();
        }


    }
}
