package com.example.virtualroom;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

import uk.co.senab.photoview.PhotoViewAttacher;

public class ReadFromDataBaseActivity extends FragmentActivity implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener {

    TextView text, info, textPreview;
    ImageView img1, imagePreview, imagesecond, lolll;
    DatabaseReference myRef;
    FirebaseDatabase database;
    StorageReference storRef;
    Button back, speak, play, minus15, plus15, backy, anotherplay, anotherplusfive,
            additional, sleep;
    TextView start, finish, texting, belowtext, noknow;
    MediaPlayer mediaPlayer;
    SeekBar track, volume;
    LinearLayout draggable;
    int elapsedTime= 0;
int a = 0, b=0;
    TextToSpeech speech;
    Timer time;
    private SlidingUpPanelLayout mLayout;
    ImageView progressBar;
    File localFile;
    String audio, nameOfSearch;
    LinearLayout sample;
    CharSequence[] cha = {"через мин", "через 2 мин", "по окончании"};
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_from_data_base);
        img1 = (ImageView) findViewById(R.id.imageView);
        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        Intent intent = getIntent();
        nameOfSearch = intent.getExtras().getString("nameOfSearch");
        myRef = database.getReference("id");
        text = (TextView) findViewById(R.id.textView3);
        progressBar = (ImageView) findViewById(R.id.progressBar);
        noknow = (TextView) findViewById(R.id.noknow);
        if(MainActivity.a == 1)
            nameOfSearch = nameOfSearch+"eng";
        myRef = FirebaseDatabase.getInstance().getReference().child(nameOfSearch);
        back = (Button) findViewById(R.id.backk);
        info = (TextView) findViewById(R.id.info);
        speak = (Button) findViewById(R.id.speak);
        additional = (Button) findViewById(R.id.additional);
        draggable = (LinearLayout) findViewById(R.id.draggable);
        play = (Button) findViewById(R.id.but);
        minus15 = (Button) findViewById(R.id.minus15);
        plus15 = (Button) findViewById(R.id.plus15);
        start = (TextView) findViewById(R.id.start);
        backy = (Button) findViewById(R.id.backy);
        texting = (TextView) findViewById(R.id.texting);
        belowtext = (TextView) findViewById(R.id.textDown);
        sleep = (Button) findViewById(R.id.sleep);
        anotherplay = (Button) findViewById(R.id.anotherplay);
        anotherplusfive = (Button) findViewById(R.id.anotherplus5);
        imagePreview = (ImageView) findViewById(R.id.imagepreview);
        imagesecond = (ImageView) findViewById(R.id.image);
        textPreview = (TextView) findViewById(R.id.textpreview);
        finish = (TextView) findViewById(R.id.end);
        final String lol,ll;

        if(MainActivity.a == 1)
        {
            noknow.setText("Text");
            cha = new CharSequence[]{"in 1 minute", "in 2 minutes", "by the end"};
            additional.setText("show");

        }


        mLayout = (SlidingUpPanelLayout) findViewById(R.id.activity_red);
        mLayout.setAnchorPoint(1f);
        mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                if (mLayout.getPanelState().toString()!= "COLLAPSED")
                {
                    anotherplusfive.setVisibility(View.INVISIBLE);
                    anotherplay.setVisibility(View.INVISIBLE);
                    imagePreview.setVisibility(View.INVISIBLE);
                    textPreview.setVisibility(View.INVISIBLE);
                } else {
                    anotherplusfive.setVisibility(View.VISIBLE);
                    anotherplay.setVisibility(View.VISIBLE);
                    imagePreview.setVisibility(View.VISIBLE);
                    textPreview.setVisibility(View.VISIBLE);
                }

            }
        });


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                text.setText(dataSnapshot.child("text").getValue(String.class));
                info.setText(dataSnapshot.child("name").getValue(String.class));
                info.setSelected(true);
                texting.setText(dataSnapshot.child("name").getValue(String.class));
                texting.setSelected(true);
                String url = dataSnapshot.child("image1").getValue(String.class);
                FirebaseStorage storage = FirebaseStorage.getInstance();
                //File file = dataSnapshot.child("audio").getValue(File.class);
                Glide.with(getApplicationContext()).load(url).into(img1);
                Glide.with(getApplicationContext()).load(url).into(imagePreview);
                Glide.with(getApplicationContext()).load(url).into(imagesecond);
                text.setMovementMethod(new ScrollingMovementMethod());
                progressBar.setVisibility(View.INVISIBLE);
                text.setVisibility(View.VISIBLE);
                info.setVisibility(View.VISIBLE);
                img1.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
                draggable.setVisibility(View.VISIBLE);
                PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(img1);
                photoViewAttacher.update();
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setOnBufferingUpdateListener(null);
                mediaPlayer.setOnCompletionListener(null);
                try {
                    mediaPlayer.setDataSource(dataSnapshot.child("audio").getValue(String.class));
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "not working", Toast.LENGTH_SHORT).show();
                }

                speak.setVisibility(View.VISIBLE);


            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                text.setText("damn.");
            }
        });

        //downloadFile();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMenu = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(toMenu);
                mediaPlayer.stop();
            }
        });
        speech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR) {
                    Locale locale = new Locale("us");
                    speech.setLanguage(locale);

                }
            }
        });


        additional.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(additional.getText()=="показать") {
                    belowtext.setText(text.getText());
                    belowtext.setVisibility(View.VISIBLE);
                    if(MainActivity.a == 1)
                        additional.setText("hide");
                    additional.setText("скрыть");
                } else {
                    belowtext.setVisibility(View.GONE);
                    if (MainActivity.a == 1)
                        additional.setText("show");
                    additional.setText("показать");
                }
            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showAlert();

                new CountDownTimer(a, a) {

                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        mediaPlayer.pause();
                        anotherplay.setBackgroundResource(R.drawable.play);
                        play.setBackgroundResource(R.drawable.play);
                    }
                }.start();
            }
        });

        //process for creating music player
        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toSpeak = text.getText().toString();
                //speech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                textPreview.setText(info.getText());
                textPreview.setSelected(true);
                textPreview.setVisibility(View.VISIBLE);
                anotherplay.setVisibility(View.VISIBLE);
                anotherplusfive.setVisibility(View.VISIBLE);
                imagePreview.setVisibility(View.VISIBLE);

                speak.setVisibility(View.VISIBLE);
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
                                track.setProgress(mediaPlayer.getCurrentPosition());
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

                anotherplusfive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 5000);
                    }
                });

                plus15.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 5000);
                    }
                });
                }

        });

    }

    public void onPause() {
        if(speech!=null)
        {
            speech.stop();
            speech.shutdown();
        }
        super.onPause();
    }

    private void downloadFile() {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        File rootPath = new File(Environment.getExternalStorageDirectory(), "file_name");
        if(!rootPath.exists()) {
            rootPath.mkdirs();
        }

        localFile = new File(rootPath,nameOfSearch+".mp3");

        StorageReference storageRef = storage.getReferenceFromUrl("gs://cool-kids-project.appspot.com/");
        Toast.makeText(getApplicationContext(),"nice", Toast.LENGTH_SHORT).show();
        StorageReference  islandRef = storageRef.child(nameOfSearch+".mp3");
        if(localFile!=null)
        islandRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
                speak.setVisibility(View.VISIBLE);
                Log.e("firebase ",";local tem file created  created " +localFile.toString());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                Log.e("firebase ",";local tem file not created  created " +exception.toString());
                Toast.makeText(getApplicationContext(),";local tem file not created  created " +exception.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mLayout != null &&
                (mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED || mLayout.getPanelState() == SlidingUpPanelLayout.PanelState.ANCHORED)) {
            mLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
        } else {
            super.onBackPressed();
            mediaPlayer.stop();
            Intent tomen = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(tomen);
        }
    }



    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int currenPosition = msg.what;

            String time = createTimeLabel(currenPosition);
            start.setText(time);
            String remainingtime  = createTimeLabel(elapsedTime - currenPosition);
            b = elapsedTime - currenPosition;
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
            play.setBackgroundResource(R.drawable.pause);
            anotherplay.setBackgroundResource(R.drawable.pause);
        } else {
            mediaPlayer.pause();
            play.setBackgroundResource(R.drawable.play);
            anotherplay.setBackgroundResource(R.drawable.play);
        }


    }

    @Override
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {


    }


    public void showAlert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setItems(cha, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                    if(cha[i].toString() == "через мин")
                        a = 60000;
                    else if(cha[i].toString() == "через 2 мин")
                        a = 120000;
                    else if(cha[i].toString() == "по окончании")
                        a = b;
                Toast.makeText(getApplicationContext(), cha[i].toString(), Toast.LENGTH_SHORT).show();


            }
        });

        alertDialog = builder.create();
        alertDialog.show();
    }

}
