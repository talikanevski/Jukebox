package com.example.com.jukebox;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * {@link SongAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link Song} objects.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    private static final String LOG_TAG = SongAdapter.class.getSimpleName();

    /**
     * param context        The current context. Used to inflate the layout file.
     * //param songs A List of Song objects to display in a list
     **/

    public SongAdapter(Activity context, ArrayList<Song> songs) {

        super(context, 0, songs);
    }

    /**
     * Provides a view for an AdapterView
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /** Check if the existing view is being reused, otherwise inflate the view**/
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        /** Get the {@link Song} object located at this position in the list**/
        final Song currentSong = getItem(position);


        /** Find the TextView in the listview_song.xml layout with the ID version_name**/
        TextView s = (TextView) listItemView.findViewById(R.id.song);

        /** Get the version name from the current Song object and
         // set this text on the name TextView**/
        s.setText(currentSong.getSongName());

        /** Find the TextView in the list_item.xml layout with the ID version_number**/
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.artist);

        /** Get the version number from the current Song object and
         // set this text on the number TextView**/
        numberTextView.setText(currentSong.getArtistName());

        /** Find the ImageView in the list_item.xml layout with the ID list_item_icon**/
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.artist_icon);

        /**Get the image resource ID from the current AndroidFlavor object and
         // set the image to iconView**/
        iconView.setImageResource(currentSong.getImageResourceId());

        /** Find the ImageView in the artists_list.xml layout with the ID list_item_icon**/
        final ImageView iconfavorites = (ImageView) listItemView.findViewById(R.id.favorites);

        /** Get the image resource ID from the current Artist object and
         // set the image to iconView**/
        if (currentSong.getFavorites() == 1)
            iconfavorites.setImageResource(R.drawable.favorites_red);
        else
            iconfavorites.setImageResource(R.drawable.favorites);

        /** Set a click listener on that Image**/
        iconfavorites.setOnClickListener(new View.OnClickListener() {
            /** The code in this method will be executed when the ImageView is clicked on.**/
            @Override
            public void onClick(View view) {
                if (currentSong.getFavorites() == 1) {
                    currentSong.setFavorites(0);
                    iconfavorites.setImageResource(R.drawable.favorites);
                } else {
                    currentSong.setFavorites(1);
                    iconfavorites.setImageResource(R.drawable.favorites_red);
                }
            }
        });

        /** Return the whole list item layout (containing 2 TextViews and an ImageView)
         // so that it can be shown in the ListView**/
        return listItemView;
    }

}
