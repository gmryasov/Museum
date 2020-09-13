package com.example.virtualroom;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends FragmentActivity {

    Button click, tomain, site;
    private int REQUEST_CODE = 1;
    Button ru, en;
    protected static int a;
    TextView photomuseum, metenkov;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)
        {

        } else {
            requestCameraPermission();
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED)
        {

        } else {
            requestLocationPermission();
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.INTERNET)== PackageManager.PERMISSION_GRANTED)
        {

        } else {
            requestInternetPermission();
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.VIBRATE)== PackageManager.PERMISSION_GRANTED)
        {

        } else {
            requestVibratePermission();
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
        {

        } else {
            requestReadPermission();
        }

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED)
        {

        } else {
            requestWritePermission();
        }


        ru = (Button) findViewById(R.id.ru);
        en = (Button) findViewById(R.id.eng);
        click = (Button) findViewById(R.id.menu);

        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photomuseum.setBackgroundResource(R.drawable.photographic_museum);
                metenkov.setBackgroundResource(R.drawable.metenkov_house);
                a = 1;

            }
        });

        ru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                photomuseum.setBackgroundResource(R.drawable.photo);
                metenkov.setBackgroundResource(R.drawable.dommet);
                a = 0;
            }
        });


        photomuseum = (TextView) findViewById(R.id.photomuseum);
        metenkov = (TextView) findViewById(R.id.metenkov);

        View.OnClickListener clk = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openactivity2();
            }
        };
        click.setOnClickListener(clk);

        site = (Button) findViewById(R.id.web_site);
        View.OnClickListener sit = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kontakti = new Intent(Intent.ACTION_VIEW);
                kontakti.setData(Uri.parse("http://dommetenkova.ru"));
                startActivity(kontakti);
            }
        };
        site.setOnClickListener(sit);

    }

    private void requestCameraPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {

        } else  {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, REQUEST_CODE);

        }

    }

    private void requestLocationPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

        } else  {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);

        }

    }

    private void requestVibratePermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.VIBRATE)) {

        } else  {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.VIBRATE}, REQUEST_CODE);

        }

    }

    private void requestInternetPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET)) {

        } else  {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.INTERNET}, REQUEST_CODE);

        }

    }

    private void requestReadPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

        } else  {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);

        }

    }

    private void requestWritePermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

        } else  {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CODE) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
            REQUEST_CODE = 1;
        } else {
            Toast.makeText(getApplicationContext(), "not ok" , Toast.LENGTH_SHORT).show();
        }
    }

    public void openactivity2() {
        Intent into = new Intent(this, MenuActivity.class);
        into.putExtra("language", a);
        startActivity(into);
    }



}
