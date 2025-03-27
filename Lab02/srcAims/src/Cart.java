public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = 
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered=0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered==MAX_NUMBERS_ORDERED-1) {
            System.out.println("The cart is full.");
        }
        else {
            itemsOrdered[qtyOrdered]=disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        int n = dvdList.length;
        if(qtyOrdered==MAX_NUMBERS_ORDERED-n) {
            System.out.println("The cart is full.");
        }
        else {
            for(int i=0; i<n; i++) {
                itemsOrdered[qtyOrdered+i] = dvdList[i];
            }
            qtyOrdered+=n;
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if(qtyOrdered==MAX_NUMBERS_ORDERED-2) {
            System.out.println("The cart is full.");
        }
        else {
            itemsOrdered[qtyOrdered]=dvd1;
            qtyOrdered++;
            itemsOrdered[qtyOrdered]=dvd2;
            qtyOrdered++;
            System.out.println("The discS has been added.");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for(int i=0; i<qtyOrdered; i++) {
            if(itemsOrdered[i]==disc) {
                while(i<qtyOrdered-1) {
                    itemsOrdered[i]=itemsOrdered[i+1];
                    i++;
                }
                qtyOrdered--;
                break;
            }
        }
        System.out.println("The disc has been removed.");
    }
    public float totalCost() {
        float total=0;
        for(int i=0; i<qtyOrdered; i++) {
            total+=itemsOrdered[i].cost;
        }
        return total;
    }

    public void printTotal() {
        for(int i=0; i<qtyOrdered; i++) {
            System.out.println(i+1 + "\t" + itemsOrdered[i].title + "\t" + itemsOrdered[i].cost + "\n");
        }
        System.out.printf("\tTotal Cost\t%.2f", totalCost());
    }
}
