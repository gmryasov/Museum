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

public class tridActivity extends FragmentActivity implements OnStreetViewPanoramaReadyCallback {

    Button back;
    String length, width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trid);
        StreetViewPanoramaFragment streetViewPanoramaFragment =
                (StreetViewPanoramaFragment) getFragmentManager()
                        .findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync((OnStreetViewPanoramaReadyCallback) this);
        length = "56.8419672";
        width = "60.6111793";
        back =(Button) findViewById(R.id.button12);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bac = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(bac);
            }
        });
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {

        streetViewPanorama.setPosition(new LatLng(Double.parseDouble(length), Double.parseDouble(width)));

    }
}
