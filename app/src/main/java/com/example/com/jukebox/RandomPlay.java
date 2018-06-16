package com.example.com.jukebox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class RandomPlay extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_play);


        SongAdapter adapter = new SongAdapter(this, MainActivity.songs);


        /** Get a reference to the ListView, and attach the adapter to the listView.**/
        ListView listView = (ListView) findViewById(R.id.listview_song);
        listView.setAdapter(adapter);

        /**Find the Button that shows the "Play random" category**/
        final Button play = (Button) findViewById(R.id.play);

        /** Set a click listener on that button**/
        play.setOnClickListener(new View.OnClickListener() {

            /** The code in this method will be executed when the numbers category is clicked on.**/
            @Override
            public void onClick(View view) {
                if (play.getText().toString().equals("PLAY RANDOM")) {
                    play.setText("PAUSE");

                    Collections.shuffle(MainActivity.songs);//It changes the order of the songs

                } else {
                    if (play.getText().toString().equals("PAUSE")) {
                        play.setText("PLAY RANDOM");
                    }
                }
            }
        });
    }
}