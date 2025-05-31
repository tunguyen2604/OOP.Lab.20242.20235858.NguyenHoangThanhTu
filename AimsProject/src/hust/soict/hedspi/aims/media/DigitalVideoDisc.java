package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Media implements Playable {
    private String director;
    private int length;
    
    public String getDirector() {
        return director;
    }
    public int getLength() {
        return length;
    }
    
    public DigitalVideoDisc(int id, String title) {
        super(id, title);
    }
    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }
    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
        super(id, title, category, cost);
        this.director = director;
    }
    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        super(id, title, category,cost);
        this.director = director;
        this.length = length;
    }
    public String toString() {
        return getTitle() + "\t" + getCategory() + "\t" + getDirector() + "\t" + getLength() + "\t" + getCost();
    }

    public boolean isMatch(String titleString) {
        boolean matched = false;
        if(this.getTitle() == titleString) matched = true;
        return matched;
    }

    public void play() throws PlayerException{
        if(this.getLength() >0 ) {
        System.out.println("Playing DVD: " + this.getTitle());
        
        System.out.println("DVD length: " + this.getLength());
        }
        else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
        
    }
}
