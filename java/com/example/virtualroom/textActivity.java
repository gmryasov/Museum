package com.example.virtualroom;

import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Locale;

public class textActivity extends FragmentActivity {

    TextView textOfZal,vids;
    Button to3d, bacco, playone, guide;

    String length, width;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        length = "56.8419672";
        width = "60.6111793";
        guide = (Button) findViewById(R.id.guide);
        vids = (TextView) findViewById(R.id.vids);
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


        textOfZal = (TextView) findViewById(R.id.textofzal);
        playone = (Button) findViewById(R.id.playone);

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
        textOfZal.setText("«ВИДЫ УРАЛА Выставка «Виды Урала» приурочена к 162-летию Вениамина Метенкова, известного уральского фотографа рубежа XIX—XX веков. Вениамин Леонтьевич известен прежде всего как фотолетописец Екатеринбурга. Практически все ранние снимки города, которые сегодня широко растиражированы, принадлежат его авторству. Однако в этой экспозиции было решено отойти от привычного образа Метенкова, раскрыв иную грань его фотографической деятельности, а именно документацию видов всего Уральского региона — от известных городов, таких как Златоуст и Верхотурье, до пустынных горных пейзажей и глухих деревень. Сегодня можно задаться вопросом: кто зритель этих старинных снимков, в каком режиме они продолжают существовать в современном мире и как их рассматривать человеку цифровой культуры? Безусловно, эти фотографии носят ценность историческую, что раскрывает экспозиция в первом зале. Мы видим, вокруг чего выстраивалась человеческая деятельность эпохи Метенкова: железнодорожный бум, высокий уровень индустриализации — потому у Вениамина Леонтьевича встречается большое количество изображений фабрик, заводов и рудников. Метенков фиксирует также архитектуру, например воеводский дом в Соликамске — старейшее гражданское здание на Северном Урале. Или знаменательные события, такие как феноменальный по степени урона пожар в Невьянске, произошедший 23 мая 1890 года — его последствия подробно отснял Вениамин Леонтьевич. Фотографии в те времена существовали на стеклянных пластинах в виде негативов, на выставке предлагается ознакомиться с имитацией подобного способа фиксации и хранения изображения. На любом носителе снимки подвергаются деформации — стекла бьются, по ним идут трещины, размывается эмульсия. Сам материал покрывается следами времени, которые на выставке решено было сохранить, оставив на многих кадрах царапины, сколы и иные отметки постепенного распада изображения. Непосредственно в момент их создания кадры могли не иметь исторической ценности. Но для фотографа часто важно установить связь со своими современниками, с людьми, которые его окружают, поэтому во втором зале выставки «Виды Урала» можно ознакомиться с изображениями представителей различных слоев общества. Для городского жителя рубежа веков фотография могла восприниматься как аттракцион, забава — эта тенденция представлена через стереофотографию, которая создавала объемные миражи и весьма развлекала публику. Для рабочих, мастеров, жителей деревень фотограф мог быть интересен и любопытен сам по себе, а потому они с удовольствием ему позировали, или же он сам заставал их за рабочим процессом. В любом случае, эти снимки можно назвать обращением к обществу, частью которого является автор. Метенков делал фотографии и для обеспечения себя. Изначально видовые открытки были основным продуктом его деятельности. Первую славу и капитал он заработал именно на сериях карточек, которые сделали Урал визуально узнаваемым не только во всей Российской империи, но и за ее пределами. «Виды Урала» — название одной из самых известных серий открыток Метенкова. Сегодня ключом к пониманию метенковских кадров может стать чуткий взгляд исследователя. Интерес к его фотографиям возникает при внимательном их просмотре, при обнаружении на них неочевидных деталей — фигур в многослойной композиции, поз людей и животных. Можно созерцать плывущий по небу дым заводской трубы столетней давности и иные смазанные временем подробности. Наш взгляд и взгляд Метенкова разделяет больше сотни лет, но они способны соединиться в пространстве любого из этих снимков.");

        if(MainActivity.a == 1)
        {
            to3d.setBackgroundResource(R.drawable.trd_tour);
            guide.setBackgroundResource(R.drawable.guideall);
            vids.setBackgroundResource(R.drawable.ural_sights);
            textOfZal.setText("\n" +
                    " \n" +
                    "\"URAL TYPES\n" +
                    "The exhibition \"Views of the Urals\" is dedicated to the 162th anniversary of Veniamin Metenkov, famous\n" +
                    "Ural photographer of the turn of the XIX — XX centuries. Veniamin Leontyevich known\n" +
                    "primarily as a photo chronicler of Yekaterinburg. Almost all early shots\n" +
                    "cities that are widely replicated today belong to its authorship.\n" +
                    "However, in this exhibition it was decided to move away from the usual image of Metenkov,\n" +
                    "revealing a different facet of his photographic activity, namely documentation\n" +
                    "views of the entire Ural region - from famous cities such as Chrysostom and\n" +
                    "Verkhoturye, to desert mountain landscapes and remote villages.\n" +
                    "Today one may wonder: who is the viewer of these old photographs, in which\n" +
                    "mode, they continue to exist in the modern world and how to treat them\n" +
                    "digital culture man?\n" +
                    "Of course, these photos are of historical value, which reveals\n" +
                    "exposure in the first hall. We see the human being built around\n" +
                    "activities of the Metenkov era: railway boom, high level\n" +
                    "industrialization - therefore Benjamin Leontievich has a big\n" +
                    "number of images of factories, plants and mines. Methenkov also fixes\n" +
                    "architecture, for example, the voivodship house in Solikamsk is the oldest civil\n" +
                    "building in the Northern Urals. Or significant events such as phenomenal\n" +
                    "according to the degree of damage, the fire in Nevyansk that occurred on May 23, 1890 - its\n" +
                    "Veniamin Leontievich filmed the consequences in detail.\n" +
                    "Photos in those days existed on glass plates in the form of negatives,\n" +
                    "and at the exhibition are invited to get acquainted with the imitation of a similar method of fixation\n" +
                    "and image storage. On any media images are subject to deformation -\n" +
                    "glass breaks, cracks go along them, emulsion is washed away. Material itself\n" +
                    "covered with traces of time, which it was decided to save at the exhibition,\n" +
                    "leaving scratches, chips and other marks of gradual decay on many frames\n" +
                    "Images.\n" +
                    "Immediately at the time of their creation, the frames could have no historical\n" +
                    "values. But it’s often important for a photographer to connect with his\n" +
                    "contemporaries, with people who surround him, therefore in the second hall\n" +
                    "exhibition \"Views of the Urals\" can be found with images of representatives\n" +
                    "different backgrounds. For a city dweller of the turn of the century, photography could\n" +
                    "perceived as an attraction, fun - this trend is presented through\n" +
                    "stereo photo that created voluminous mirages and was quite entertaining\n" +
                    "public. For workers, craftsmen, villagers, a photographer could be interesting and\n" +
                    "curious in itself, but because they are happy to pose for him, or he\n" +
                    "he himself found them behind the workflow. In any case, these pictures can be called\n" +
                    "appeal to the society of which the author is a part.\n" +
                    "Metenkov also took photographs for himself. Initially specific postcards\n" +
                    "were the main product of its activities. The first glory and capital he earned\n" +
                    "on the series of cards that made the Ural visually recognizable not only\n" +
                    "throughout the Russian Empire, but also abroad. \"Types of the Urals\" - the name of one\n" +
                    "of the most famous series of cards Metenkov.\n" +
                    "\n" +
                    "Today, a sensitive look can be the key to understanding the methenkov frames.\n" +
                    "the researcher. Interest in his photographs arises when they are attentive.\n" +
                    "viewing, when they detect unobvious details - figures in a multi-layered\n" +
                    "compositions, poses of people and animals. You can contemplate the smoke floating across the sky.\n" +
                    "one hundred years old factory pipe and other details smeared with time.\n" +
                    "Our vision and that of Metenkov are more than a hundred years apart, but they are capable\n" +
                    "connect in the space of any of these snapshots.\"");

        }


        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnBufferingUpdateListener(null);
        mediaPlayer.setOnCompletionListener(null);
        try {
            mediaPlayer.setDataSource("https://firebasestorage.googleapis.com/v0/b/cool-kids-project.appspot.com/o/vidi_urala.mp3?alt=media&token=1c3bc928-453b-4b28-bc92-e42bc96a569b");//ссылка на аудио в формате URL
            mediaPlayer.prepare();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "not working", Toast.LENGTH_SHORT).show();
        }
        mediaPlayer.seekTo(0);
        mediaPlayer.setVolume(2f, 2f);

        playone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mediaPlayer.isPlaying()) {
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


