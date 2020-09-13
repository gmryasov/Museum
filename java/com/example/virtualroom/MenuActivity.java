package com.example.virtualroom;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MenuActivity extends FragmentActivity {

    Button home , trid , ar , audio , text , site, qrReader, vistavka, sobitiya, omuzee, map, kontakti ;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        home = (Button) findViewById(R.id.logo);
        trid = (Button) findViewById(R.id.threeD);
        ar = (Button) findViewById(R.id.ar_search);
        //audio = (Button) findViewById(R.id.button6);
        text = (Button) findViewById(R.id.text_gid);
        site = (Button) findViewById(R.id.web_site);
        kontakti = (Button) findViewById(R.id.kontakti);
        qrReader = (Button) findViewById(R.id.qr_skan);
        vistavka = (Button) findViewById(R.id.vistavka);
        sobitiya = (Button) findViewById(R.id.sobitiya);
        omuzee = (Button) findViewById(R.id.omuzee);
        map = (Button) findViewById(R.id.map);

        if(MainActivity.a == 1)
        {
            home.setBackgroundResource(R.drawable.dommetenkovaone);
            trid.setBackgroundResource(R.drawable.trid_tourone);
            vistavka.setBackgroundResource(R.drawable.exhibitionsone);
            omuzee.setBackgroundResource(R.drawable.about_museumone);
            map.setBackgroundResource(R.drawable.museum_mapone);
            text.setBackgroundResource(R.drawable.guideone);
            kontakti.setBackgroundResource(R.drawable.contactsone);
            sobitiya.setBackgroundResource(R.drawable.eventsone);
            qrReader.setBackgroundResource(R.drawable.qr_scannerone);

        }

        View.OnClickListener hom = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in);
            }
        };
        home.setOnClickListener(hom);

        View.OnClickListener tri = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tofull = new Intent(getApplicationContext(), tridActivity.class);
                startActivity(tofull);
            }
        };
        trid.setOnClickListener(tri);

        View.OnClickListener a = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), MusicActivity.class);
                startActivity(in);
            }
        };
        ar.setOnClickListener(a);



        View.OnClickListener tex = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toText = new Intent(getApplicationContext(), AllgidActivity.class);
                startActivity(toText);
            }
        };
        text.setOnClickListener(tex);

        View.OnClickListener sit = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView web = new WebView(getApplicationContext());
                setContentView(web);
                web.loadUrl("http://dommetenkova.ru");
            }
        };
        site.setOnClickListener(sit);

        qrReader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toQR = new Intent(getApplicationContext(), QRActivity.class);
                startActivity(toQR);
            }
        });

        vistavka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_VIEW);
                in.setData(Uri.parse("http://dommetenkova.ru/exhibitions"));
                startActivity(in);
            }
        });

        sobitiya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ino = new Intent(Intent.ACTION_VIEW);
                ino.setData(Uri.parse("http://dommetenkova.ru/events"));
                startActivity(ino);
            }
        });

        omuzee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent omuz = new Intent(Intent.ACTION_VIEW);
                omuz.setData(Uri.parse("http://dommetenkova.ru/aboutmuseum"));
                startActivity(omuz);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map  = new Intent(getApplicationContext(), MapOfMuseumActivity.class);
                startActivity(map);
            }
        });

        kontakti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kontakti = new Intent(Intent.ACTION_VIEW);
                kontakti.setData(Uri.parse("http://dommetenkova.ru/forvisitors"));
                startActivity(kontakti);
            }
        });
    }
}
