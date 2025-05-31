package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> Tracks = new ArrayList<Track>();

    CompactDisc(int id, String title) {
        super(id, title);
    }

    public CompactDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    CompactDisc(int id, String title, float cost) {
        super(id, title, cost);
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Track> getTracks() {
        return Tracks;
    }

    public void setTracks(List<Track> tracks) {
        Tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if(Tracks.indexOf(track) != -1) {
            System.out.println(track + " is already in the list.");
            return;
        }
        Tracks.add(track);
        System.out.println(track + " is added to the list.");
    }

    public void removeTrack(Track track) {
        if(Tracks.indexOf(track) == -1) {
            System.out.println(track + " is not in the list.");
            return;
        }
        Tracks.remove(track);
        System.out.println(track + " is removed from the list.");
    }

    public int getLength() {
        int sum = 0;
        for(Track t : Tracks) sum += t.getLength();
        return sum;
    }

    public void play() throws PlayerException{
        if(this.getLength() > 0) {
        System.out.println("Playing CD: " + this.getTitle());
        
        System.out.println("Artist: " + this.getArtist());

        java.util.Iterator iter = Tracks.iterator();
        Track nextTrack;
        while(iter.hasNext()) {
            nextTrack = (Track)iter.next();
            try {
                nextTrack.play();
            } catch(PlayerException e) {
                System.err.println("Error playing track: " + nextTrack.getTitle());
                throw e;
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
        
    }

    public String toString() {
        return getTitle() + "\t" + getCategory() + "\t" + getArtist() + "\t" + getCost();
    }
}
