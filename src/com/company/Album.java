package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String Artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        Artist = artist;
        this.songs = new ArrayList<Song>();
    }

    public boolean addSong(String title, double duration) {
        if(findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        } else {
            System.out.println("Song already exists in your song list");
            return false;
        }
    }

    private Song findSong(String title) {
        for(int i=0; i<songs.size(); i++) {
            Song song = this.songs.get(i);
            if(song.getTitle().equals(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber -1;
        if((index >= 0) && (index <= this.songs.size())) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not ha a track " + trackNumber);
        return false;
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song checkedSong = findSong(title);
        if(checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " has been added to is not in this album");
        return false;
    }
}
