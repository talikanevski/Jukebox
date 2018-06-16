package com.example.com.jukebox;
/**
 * {@link Song} represents a single Android platform release.
 * Each object has 4 properties: name of a song, name of an artist, image resource ID, and button "add to favorites"
 */
public class Song {
    //name of a song
    private String mName;
    //artist name
    private String mArtist;
    // Drawable resource ID
    private int mImageResourceId;
    //favorites button
    private int mfavorites;

    /**
     * Create a new Song object.
     * @param name is the name of the song (e.g. Radioactive)
     * @param artist is the name of the artist (e.g. The Rolling Stones )
     * @param imageResourceId is drawable reference ID that corresponds to the Android version
     * @param favorites is drawable reference ID that corresponds to the Android version       */
    public Song(String name, String artist, int imageResourceId, int favorites)
    {
        mName = name;
        mArtist = artist;
        mImageResourceId = imageResourceId;
        mfavorites = favorites;
    }

    /**
     * Get the name of the song
     */
    public String getSongName() {
        return mName;
    }

    /**
     * Get the name of the artist
     */
    public String getArtistName() {
        return mArtist;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getFavorites() { return mfavorites;}

    public void setFavorites(int value) {mfavorites = value;}

}
