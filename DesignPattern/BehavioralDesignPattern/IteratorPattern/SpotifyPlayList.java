package DesignPattern.BehavioralDesignPattern.IteratorPattern;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Song {
    private String name;
    private String artist;

    public Song(String name, String artist) {
        this.name = name;
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }
}

//Iterator Interface
interface PlaylistIteratorInterface {
    boolean hasNext();
    Song next();
}

//concrete iterator
class NormalPlaylistIterator implements PlaylistIteratorInterface {
    private List<Song> songs;
    private int current = 0;

    public NormalPlaylistIterator(List<Song> songs) {
        this.songs = songs;
    }

    public boolean hasNext() {
        return current < songs.size();
    }

    public Song next() {
        if (hasNext()) {
            return songs.get(current++);
        }
        return null;
    }
}


class ShufflePlaylistIterator implements PlaylistIteratorInterface {
    private List<Song> shuffledSongs;
    private int current = 0;

    public ShufflePlaylistIterator(List<Song> songs) {
        shuffledSongs = new ArrayList<>(songs);
        Collections.shuffle(shuffledSongs);
    }

    public boolean hasNext() {
        return current < shuffledSongs.size();
    }

    public Song next() {
        if (hasNext()) {
            return shuffledSongs.get(current++);
        }
        return null;
    }
}

//Inventory/PlayList that actually creates iterator
class Playlist {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public PlaylistIteratorInterface createNormalIterator() {
        return new NormalPlaylistIterator(songs);
    }

    public PlaylistIteratorInterface createShuffleIterator() {
        return new ShufflePlaylistIterator(songs);
    }
}


public class SpotifyPlayList {
    public static void main(String[] args) {

        Playlist playlist = new Playlist();

        playlist.addSong(new Song("Sunflower", "Post Malone and Swae Lee"));
        playlist.addSong(new Song("Shape of You", "Ed Sheeran"));
        playlist.addSong(new Song("Blank Space", "Taylor Swift"));
        playlist.addSong(new Song("Blinding Lights", "The Weeknd"));
        playlist.addSong(new Song("Havana", "Camila Cabello "));

        // Choose normal or shuffle traversal
        PlaylistIteratorInterface iterator =
                playlist.createShuffleIterator();

        while (iterator.hasNext()) {
            Song song = iterator.next();

            System.out.println(song.getName() + " - " + song.getArtist());
        }
    }
}

//aggregation -The song can exist even if the playlist is deleted. So aggregation is a reasonable domain model.
//association-Iterator and Song Both iterators maintain a List<Song> reference. They traverse existing songs; they don't own the songs' lifecycle.