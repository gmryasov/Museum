package com.example.virtualroom;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AllgidActivity extends FragmentActivity {

    Button zalone, zaltwo, zalthree, bacco;
    ImageView guide, vids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allgid);
        zalone = (Button) findViewById(R.id.zalone);
        zaltwo = (Button) findViewById(R.id.zaltwo);
        guide = (ImageView) findViewById(R.id.guide);
        vids = (ImageView) findViewById(R.id.vids);
        zalthree = (Button) findViewById(R.id.zalthree);

        if(MainActivity.a == 1)
        {
            zalone.setBackgroundResource(R.drawable.room_1);
            zaltwo.setBackgroundResource(R.drawable.room_2);
            zalthree.setBackgroundResource(R.drawable.room_3);
            guide.setBackgroundResource(R.drawable.guideall);
            vids.setBackgroundResource(R.drawable.ural_sights);
        }

        zalone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toZalOne = new Intent(getApplicationContext(), textActivity.class);
                startActivity(toZalOne);
            }
        });

        zaltwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toZalOne = new Intent(getApplicationContext(), Zal2Activity.class);
                startActivity(toZalOne);
            }
        });

        zalthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toZalOne = new Intent(getApplicationContext(), Zal3Activity.class);
                startActivity(toZalOne);
            }
        });

        bacco = (Button) findViewById(R.id.bacco);
        bacco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMenu = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(toMenu);
            }
        });

    }
}
