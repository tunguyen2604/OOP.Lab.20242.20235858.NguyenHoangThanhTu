package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media m) {
        if(itemsInStore.indexOf(m) != -1) {
            System.out.println("This item is already in the store.");
            return;
        }
        itemsInStore.add(m);
        return;
    }

    public void removeMedia(Media m) {
        if(itemsInStore.indexOf(m) == -1) {
            System.out.println("This item is not in the store.");
            return;
        }
        itemsInStore.remove(m);
        return;
    }

    public int size() {
        return itemsInStore.size();
    }

    public void printAll() {
        for(Media m : itemsInStore) System.out.println(m.toString());
    }

    public Media searchByTitle(String title) {
        for(Media m : itemsInStore) {
            if(m.getTitle().compareTo(title) == 0) {
                return m;
            }
        }
        return null;
    }

}
