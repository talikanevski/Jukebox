package com.example.com.jukebox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class Favorites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** pass selected songs to ArrayList of favorites artists  **/
        MainActivity.favoriteArtists.clear();

        for (int i = 0; i < MainActivity.songs.size(); i++) {
            Song currentSong = MainActivity.songs.get(i);
            if (currentSong.getFavorites() == 1) {
                MainActivity.favoriteArtists.add(currentSong);
            }
        }
        //remove already existed favorites songs if deselected from Favorites activity
        for (int i = 0; i < MainActivity.favoriteArtists.size(); i++) {
            Song currentSong = MainActivity.favoriteArtists.get(i);
            if (currentSong.getFavorites() == 0) {
                MainActivity.favoriteArtists.remove(currentSong);
            }
        }

        setContentView(R.layout.activity_favorites);

        SongAdapter adapter = new SongAdapter(this, MainActivity.favoriteArtists);

        /** Get a reference to the ListView, and attach the adapter to the listView.**/
        ListView listView = (ListView) findViewById(R.id.listview_song);
        listView.setAdapter(adapter);

        final Button play = (Button) findViewById(R.id.play);

        /** Set a click listener on that button**/
        play.setOnClickListener(new View.OnClickListener() {

            /** The code in this method will be executed when the numbers category is clicked on.**/
            @Override
            public void onClick(View view) {
                if (play.getText().toString().equals("PLAY RANDOM")) {
                    play.setText("PAUSE");

                    Collections.shuffle(MainActivity.favoriteArtists);//It changes the order of the songs

                } else {
                    if (play.getText().toString().equals("PAUSE")) {
                        play.setText("PLAY RANDOM");
                    }
                }
            }
        });

    }
}
