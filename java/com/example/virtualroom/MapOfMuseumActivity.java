package com.example.virtualroom;

import android.content.pm.ActivityInfo;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MapOfMuseumActivity extends FragmentActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_of_museum);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        img = (ImageView) findViewById(R.id.mappo);
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(img);
        photoViewAttacher.update();
    }
}
