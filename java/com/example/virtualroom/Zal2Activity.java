package com.example.virtualroom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Zal2Activity extends FragmentActivity {

    TextView textOfZal,vids;
    Button to3d, bacco, playone, guide;

    String length, width;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zal2);
        length = "56.8419558";
        width = "60.6109463";

        guide = (Button) findViewById(R.id.guide);
        vids = (TextView) findViewById(R.id.vids);
        playone = (Button) findViewById(R.id.playone);
        textOfZal = (TextView) findViewById(R.id.textofzal);
        to3d = (Button) findViewById(R.id.gototrid);
        to3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to3dgo = new Intent(getApplicationContext(), tridtoActivity.class);
                to3dgo.putExtra("length", length);
                to3dgo.putExtra("width", width);
                startActivity(to3dgo);
            }
        });

        bacco = (Button) findViewById(R.id.bacco);
        bacco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMenu = new Intent(getApplicationContext(), AllgidActivity.class);
                mediaPlayer.stop();
                startActivity(toMenu);
            }
        });

        textOfZal.setMovementMethod(new ScrollingMovementMethod());
        textOfZal.setText("ДОРЕВОЛЮЦИОННЫЕ ОТКРЫТКИ \n" +
                "Вениамин Метенков заказывал печать открыток в зарубежных типографиях, поэтому на оборотах его карточек можно увидеть берлинские адреса. При помощи открыток Метенков формировал и транслировал образ Урала как бренда. Его почтовые карточки пользовались большой популярнос-тью как в России, так и в Европе; за них Метенков не единожды удостаивался престижных наград, втомчисле получил бронзовую медаль «за творческие достижения в Брюсселе. \n" +
                "На открытках он заслужил сваю славу, позволившую ему заработать свой первый серьезный капи-тал, вложенный всемью и совместное ведение фотографических дел. ");


        if(MainActivity.a == 1)
        {
            to3d.setBackgroundResource(R.drawable.trd_tour);
            guide.setBackgroundResource(R.drawable.guideall);
            vids.setBackgroundResource(R.drawable.ural_sights);
            textOfZal.setText("PRE-REVOLUTIONARY CARDS\n" +
                    "\"Veniamin Metenkov ordered the printing of postcards in foreign printing houses, so Berlin addresses can be seen on the backs of his cards. With the help of postcards Metenkov formed and transmitted the image of the Urals as a brand. His postcards were very popular both in Russia and in Europe; for them Metenkov more than once he won prestigious awards, including a bronze medal \"for his creative achievements in Brussels.\"\n" +
                    "\"On postcards, he earned a pile of fame, which allowed him to earn his first serious capital invested in the family and joint management of photographic affairs.");

        }

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnBufferingUpdateListener(null);
        mediaPlayer.setOnCompletionListener(null);
        try {
            mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/cool-kids-project.appspot.com/o/%D0%B4%D0%BE%D1%80%D0%B5%D0%B2%D0%BE%D0%BB%D1%8E%D1%86%D0%B8%D0%BE%D0%BD%D0%BD%D1%8B%D0%B5%20%D0%BE%D1%82%D0%BA%D1%80%D1%8B%D1%82%D0%BA%D0%B8.mp3?alt=media&token=92e11080-9fa3-462a-8731-33db4bb71bc6");//ссылка на аудио в формате URL
            mediaPlayer.prepare();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "not working", Toast.LENGTH_SHORT).show();
        }
        mediaPlayer.seekTo(0);
        mediaPlayer.setVolume(2f, 2f);

        playone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    playone.setBackgroundResource(R.drawable.pause);
                } else {
                    mediaPlayer.pause();
                    playone.setBackgroundResource(R.drawable.play);
                }
            }
        });

    }

    @Override
    public void onBackPressed() {

       super.onBackPressed();
        mediaPlayer.stop();

    }

}
