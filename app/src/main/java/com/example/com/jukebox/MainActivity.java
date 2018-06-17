package com.example.com.jukebox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final ArrayList<Song> songs = new ArrayList<Song>();
    public static final ArrayList<Song> favoriteArtists = new ArrayList<Song>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Set the content of the activity to use the activity_main.xml layout file**/
        setContentView(R.layout.activity_main);

        /** Find the LinearLayout that shows the "Play random" category**/
        LinearLayout linearLayoutPlayRandom = (LinearLayout) findViewById(R.id.linearLayoutPlayRandom);

        /** Set a click listener on that Layout**/
        linearLayoutPlayRandom.setOnClickListener(new View.OnClickListener() {

            /** The code in this method will be executed when the numbers category is clicked on.**/
            @Override
            public void onClick(View view) {

                /** Create a new intent to open the {@link RandomPlay}**/
                Intent playIntent = new Intent(MainActivity.this, RandomPlay.class);

                /** Start the new activity**/
                startActivity(playIntent);
            }
        });

        /** Find the LinearLayout that shows the "Choose artists" category**/
        LinearLayout linearLayoutChooseArtists = (LinearLayout) findViewById(R.id.linearLayoutChooseArtists);

        /** Set a click listener on that Layout**/
        linearLayoutChooseArtists.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                /** Create a new intent to open the {@link ChooseSongs}**/
                Intent playIntent = new Intent(MainActivity.this, ChooseSongs.class);

                /** Start the new activity**/
                startActivity(playIntent);
            }
        });

        /** Find the LinearLayout that shows the "Favorites" category**/
        LinearLayout linearLayoutFavorites = (LinearLayout) findViewById(R.id.linearLayoutFavorites);

        /** Set a click listener on that Layout**/
        linearLayoutFavorites.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                /** Create a new intent to open the {@link ChooseSongs}**/
                Intent playIntent = new Intent(MainActivity.this, Favorites.class);

                /** Start the new activity**/
                startActivity(playIntent);
            }
        });

        /** Create an ArrayList of Song objects**/
        songs.add(new Song(getString(R.string.hello), getString(R.string.adele), R.drawable.adele, 0));
        songs.add(new Song(getString(R.string.utopia), getString(R.string.bjork), R.drawable.bjork, 0));
        songs.add(new Song(getString(R.string.silence), getString(R.string.depeche_mode), R.drawable.depeche_mode, 0));
        songs.add(new Song(getString(R.string.everybody_nneds_somebody), getString(R.string.the_rolling_stones), R.drawable.the_rolling_stones, 0));
        songs.add(new Song(getString(R.string.hard_days_noght), getString(R.string.the_beatles), R.drawable.the_beatles, 0));
        songs.add(new Song(getString(R.string.fire), getString(R.string.the_doors), R.drawable.the_doors, 0));
        songs.add(new Song(getString(R.string.i_wish), getString(R.string.infected_mushrooms), R.drawable.infected_mushrooms, 0));
        songs.add(new Song(getString(R.string.thunder), getString(R.string.imagine_dragons), R.drawable.imagine_dragons, 0));
        songs.add(new Song(getString(R.string.i_was_born_to_love_you), getString(R.string.freddie), R.drawable.freddie_mercury, 0));

    }
}

