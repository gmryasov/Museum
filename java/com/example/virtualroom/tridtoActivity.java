package com.example.virtualroom;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

public class tridtoActivity extends FragmentActivity implements OnStreetViewPanoramaReadyCallback {

    Button back;
    String length, width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tridto);
        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync((OnStreetViewPanoramaReadyCallback) this);
        length = "56.8419182";
        width = "60.6109527";

        if(getIntent()!= null)
        {
            length = getIntent().getStringExtra("length");
            width = getIntent().getStringExtra("width");
        }

        back =(Button) findViewById(R.id.button12);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bac = new Intent(getApplicationContext(), textActivity.class);
                startActivity(bac);
            }
        });
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {

        streetViewPanorama.setPosition(new LatLng(Double.parseDouble(length), Double.parseDouble(width)));

    }
}
