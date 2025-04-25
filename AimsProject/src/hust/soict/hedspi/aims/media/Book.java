package hust.soict.hedspi.aims.media;

import java.util.*;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();
    
    public Book(int id, String title) {
        super(id, title);
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Book(int id, String title, float cost) {
        super(id, title, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if(authors.indexOf(authorName) != -1) {
                System.out.println(authorName + " is already in the list.");
                return;
        }
        authors.add(authorName);
        System.out.println(authorName + " is added to the list.");
    }

    public void removeAuthor(String authorName) {
        if(authors.indexOf(authorName) == -1) {
            System.out.println(authorName + " is not in the list.");
            return;
        }

        authors.remove(authorName);
        System.out.println(authorName + " is removed from the list.");
    }

    public String toString() {
        return getTitle() + "\t" + getCategory() + "\t" + getAuthors() + "\t" + getCost();
    }

    public void play() {
        System.out.println("You cannot play a book, please choose another item.");
    }
}
