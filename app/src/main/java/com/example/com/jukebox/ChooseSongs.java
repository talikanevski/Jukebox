package com.example.com.jukebox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ChooseSongs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_songs);

        /** Find the Button that shows the "Artists you like" category**/
        Button done = (Button) findViewById(R.id.done);

        /** Set a click listener on that Button**/
        done.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                /** Create a new intent to open the {@link ChooseSongs}**/
                Intent playIntent = new Intent(ChooseSongs.this, Favorites.class);

                /** Start the new activity**/
                startActivity(playIntent);
            }
        });

        SongAdapter adapter = new SongAdapter(this, MainActivity.songs);

        /** Get a reference to the ListView, and attach the adapter to the listView.**/
        ListView listView = (ListView) findViewById(R.id.listview_song);
        listView.setAdapter(adapter);

    }
}

