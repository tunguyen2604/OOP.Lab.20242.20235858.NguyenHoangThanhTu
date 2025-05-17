package hust.soict.hedspi.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    @Override public boolean equals(Object obj) {
        Track other = (Track) obj;
        return this.title.equals(other.getTitle()) && (this.length == other.getLength());
    }

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    
    public Track(String title) {
        this.title = title;
    }

    public void play() {

        System.out.println("Playing track: " + this.getTitle());
        
        System.out.println("Track length: " + this.getLength());
        
    }

    public String toString() {
        return getTitle() + "\t" + getLength();
    }
}
