package com.kidach1.androidswayanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.kidach1.swayanimation.SwayAnimation;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
        // for custom drawablse
//        SwayAnimation.setDrawables(Arrays.asList(
//                R.drawable.ic_favorite_pink_300_48dp,
//                R.drawable.ic_tag_faces_amber_300_48dp,
//                R.drawable.ic_thumb_up_blue_a200_48dp
//        ));
//        SwayAnimation.withActionBar(true);
        SwayAnimation.ready(layout, layout, this);
    }
}
