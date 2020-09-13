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

public class Zal3Activity extends FragmentActivity {

    TextView textOfZal,vids;
    Button to3d, bacco, playone, guide;

    String length, width;
    MediaPlayer mediaPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zal3);

        length = "56.8418636";
        width = "60.611009";


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
        textOfZal.setText("ЖИТЕЛИ УРАЛА \n" +
                "Стереофотография вошла в моду в середине ХIХ века, и каждые 10 лет она заново будора-жила умы публики, жаждавшей развлечений. Суть переозффекта состоит в создании объем-ного изображения, совмещающего два одинаковых, но смещенных под правый и левый глаз снимка. Такое заигрывание с реальностью дает ощущение объема. Стереофотография начала пользоваться успехом аттракционного характера за несколько десятилетий до изобретения кинематографа, привлекая зрителей своими реалистичными миражами. \n" +
                "Вениамин Метенков создавал стереофотографии в Екатеринбурге и близ него, используя в качестве материала как статичные памятники, парки и площади, так и бытовые сюжеты. \n" +
                "Показываемые в этом зале снимки отображают жизнь представителей буржуазного клас-са, гуляющих и катающихся на реке в беззаботные летние дни. Также демонстрируется стерео-фотография с автомобильного пробега Париж-Пекин, чей маршрут проходил через Екате-ринбург. На снимке рядом с итальянским экипажем позирует купец Агафуров. \n" +
                "Сюжеты для стереофотографий Метенков чаще всего находил, не уезжая далеко от города. 8 его объектив нередко попадали простые сцены типической жизни городских обитателей любых сословий. Подчас это были случайные прохожие или группы людей, веселящихся на народных ryляниях. \n" +
                "На противоположной пене показаны сцены из жизни простых жителей Урала - рабочих на рудниках, сапожников, бывших крепостных в башкирской деревне, занимающихся процессом межевания земли. \n" +
                "Вениамин Леонтьевич Метенков с одинаковым вниманием относился к россыпи этик харак-теровитипажей,которые он находил даже в самых отдаленных уголках родной земли. ");


        if(MainActivity.a == 1)
        {
            to3d.setBackgroundResource(R.drawable.trd_tour);
            guide.setBackgroundResource(R.drawable.guideall);
            vids.setBackgroundResource(R.drawable.ural_sights);
            textOfZal.setText("URAL RESIDENTS Stereophotography came into fashion in the mid-nineteenth century, and every 10 years it reinvented the minds of the public who craved entertainment. The essence of the re-effect is to create a three-dimensional image that combines two of the same, but shifted under the right and left eye of the picture. Such flirting with reality, it gives a sense of volume. Stereophotography began to enjoy the success of the attraction character several decades before the invention of cinema, attracting viewers with its realistic mirages. Veniamin Metenkov created stereo photographs in and around Yekaterinburg, using as a material both static monuments, parks and squares, and everyday plots. The pictures shown in this room reflect the lives of representatives of the bourgeois class who walk and ride on the river on carefree summer days. Also shows a stereo photo from the Paris-Beijing motor route, whose route passed through Yekaterinburg. The photo next to the Italian crew posing merchant Agafurov.Plots for stereo photographs Metenkov most often found without leaving far from the city. Often objective scenes of the typical life of city dwellers of any class got into its lens. Sometimes they were random passers-by or groups of people having fun at folk rylyaniyakh.The opposite froth shows scenes from the lives of ordinary residents of the Urals — workers at the mines, shoemakers, former serfs in the Bashkir village, engaged in land surveying.Veniamin Leontyevich Metenkov treated with equal attention to the placer ethics of harak-teresites, which he found even in the most remote corners of his native land.");

        }

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnBufferingUpdateListener(null);
        mediaPlayer.setOnCompletionListener(null);
        try {
            mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/cool-kids-project.appspot.com/o/%D0%B6%D0%B8%D1%82%D0%B5%D0%BB%D0%B8%20%D1%83%D1%80%D0%B0%D0%BB%D0%B0.mp3?alt=media&token=96507c57-1c85-44ef-8c55-8e1bfaba056e");//ссылка на аудио в формате URL
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
