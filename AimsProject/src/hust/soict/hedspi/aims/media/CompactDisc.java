package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> Tracks = new ArrayList<Track>();

    CompactDisc(int id, String title) {
        super(id, title);
    }

    CompactDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    CompactDisc(int id, String title, float cost) {
        super(id, title, cost);
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

    public void play() {

        System.out.println("Playing CD: " + this.getTitle());
        
        System.out.println("Artist: " + this.getArtist());

        for(Track t : Tracks) t.play();
        
    }

    public String toString() {
        return getTitle() + "\t" + getCategory() + "\t" + getArtist() + "\t" + getCost();
    }
}
