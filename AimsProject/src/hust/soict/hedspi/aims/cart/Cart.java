package hust.soict.hedspi.aims.cart;

import java.util.*;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
    private List<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media m) {
        if(itemsOrdered.indexOf(m) != -1) {
            System.out.println("This item is already in the cart.");
            return;
        }
        itemsOrdered.add(m);
        System.out.println("This item is added to the cart.");
        System.out.println("There is " + itemsOrdered.size() + " in the cart.");
        return;
    }

    public void removeMedia(Media m) {
        if(itemsOrdered.indexOf(m) == -1) {
            System.out.println("This item is not in the cart.");
            return;
        }
        itemsOrdered.remove(m);
        System.out.println("This item is removed from the cart.");
        System.out.println("There is " + itemsOrdered.size() + " in the cart.");
        return;
    }
    public float printTotal() {
        float total=0;
        for(Media m : itemsOrdered) {
            System.out.println(m.toString());
            total += m.getCost();
        }
        return total;
    }

    public void placeOrder() {
        System.out.println("An order is created.");
        itemsOrdered.clear();
    }

    public Media searchByTitle(String title) {
        for(Media m : itemsOrdered) {
            if(m.getTitle().compareTo(title) == 0) {
                return m;
            }
        }
        return null;
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new Comparator<Media>() {
        public int compare(Media m1, Media m2) {
            int titleCompare = m1.getTitle().compareTo(m2.getTitle());
            if (titleCompare != 0) return titleCompare;
            return Float.compare(m1.getCost(), m2.getCost());
        }
    };
    
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new Comparator<Media>() {
        public int compare(Media m1, Media m2) {
            int costCompare = Float.compare(m1.getCost(), m2.getCost());
            if (costCompare != 0) return costCompare;
            return m1.getTitle().compareTo(m2.getTitle());
        }
    };

    public void sortByTitle() {
        Collections.sort(itemsOrdered, COMPARE_BY_TITLE_COST);
    }
    
    public void sortByCost() {
        Collections.sort(itemsOrdered, COMPARE_BY_COST_TITLE);
    }
}