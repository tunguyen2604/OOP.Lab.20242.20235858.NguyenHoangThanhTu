package hust.soict.hedspi.aims.media;

import java.util.*;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        return (int) (m1.getCost() - m2.getCost());
    }

    public int thenComparing(Media m1, Media m2) {
        return m1.getTitle().compareTo(m2.getTitle());
    }
}
