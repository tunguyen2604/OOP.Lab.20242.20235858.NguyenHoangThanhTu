package hust.soict.hedspi.aims.Aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.store.Store;
import java.util.Scanner;
import hust.soict.hedspi.aims.media.*;

public class Aims {
    public static void main(String[] args) throws PlayerException {
        Store store = new Store();
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f);
                 
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Aladin", "Animation", 18.99f);
        
        Book book1 = new Book (3, "Life of Pi", 4.95f);


        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);


        showMenu();

        Scanner userInput = new Scanner(System.in);
        String optionString = userInput.nextLine(); 

        if(optionString.compareTo("1") == 0) {
            store.printAll();
            storeMenu();

            optionString = userInput.nextLine();
            if(optionString.compareTo("1") == 0) {
                System.out.println("Please type in the title you want to see.");

                String titleString = userInput.nextLine();
                Media m = store.searchByTitle(titleString);

                if(m != null) {
                    System.out.println(m.toString());
                    mediaDetailsMenu(m);
                }

                else System.out.println("This item doesn't exist, please check again.");
            }

            else if(optionString.compareTo("2") == 0) {
                System.out.println("Please type in the title you want to add to cart."); 

                String titleString = userInput.nextLine();
                Media m = store.searchByTitle(titleString);

                if(m != null) {
                    cart.addMedia(m);
                }

                else System.out.println("This item doesn't exist, please check again.");
            }

            else if(optionString.compareTo("3") == 0) {
                System.out.println("Please type in the title you want to play."); 

                String titleString = userInput.nextLine();
                Media m = store.searchByTitle(titleString);

                if(m != null) {
                    if(m instanceof Playable) {
                        m.play();
                    }
                    else {
                        throw new PlayerException("ERROR: Media is not playable!");
                    }
                }

                else System.out.println("This item doesn't exist, please check again.");
            }
        }
        else if(optionString.compareTo("2") == 0) {
            System.out.println("Options: ");
            
            System.out.println("--------------------------------");

            System.out.println("1. Add a media to store");
            
            System.out.println("2. Remove a media from store");

            System.out.println("0. Back");

            System.out.println("--------------------------------");

            System.out.println("Please choose a number: 0-1-2");

            optionString = userInput.nextLine();
            if(optionString.compareTo("1") == 0) {
                String title, category, stringCost;
                float cost;
                int id = store.size();
                System.out.println("Please input the title.");
                title = userInput.nextLine();
                System.out.println("Please input the category.");
                category = userInput.nextLine();
                System.out.println("Please input the cost.");
                stringCost = userInput.nextLine();
                cost = Float.parseFloat(stringCost);

                Media m = new Media(id, title, category, cost);

                store.addMedia(m);
            }

            else if(optionString.compareTo("2") == 0) {
                System.out.println("Please input the title.");

                String titleString = userInput.nextLine();
                Media m = store.searchByTitle(titleString);

                if(m != null) store.removeMedia(m);
                else System.out.println("This item doesn't exist, please check again.");
            }
        }

        else if(optionString.compareTo("3") == 0) {
            System.out.println(cart.printTotal());
            cartMenu();

            optionString = userInput.nextLine();
            if(optionString.compareTo("1") == 0) {
                System.out.println("Options: ");
            
                System.out.println("--------------------------------");

                System.out.println("1. Filter by title");
            
                System.out.println("2. Filter by id");

                System.out.println("0. Back");

                System.out.println("--------------------------------");

                System.out.println("Please choose a number: 0-1-2");

                optionString = userInput.nextLine();
                if(optionString.compareTo("1") == 0) {

                }

                else if(optionString.compareTo("2") == 0) {

                }
            }
            else if(optionString.compareTo("2") == 0) {
                System.out.println("Options: ");
            
                System.out.println("--------------------------------");

                System.out.println("1. Sort by title");
            
                System.out.println("2. Sort by cost");

                System.out.println("0. Back");

                System.out.println("--------------------------------");

                System.out.println("Please choose a number: 0-1-2");

                optionString = userInput.nextLine();
                if(optionString.compareTo("1") == 0) {
                    cart.sortByTitle();
                }

                else if(optionString.compareTo("2") == 0) {
                    cart.sortByCost();
                }
            }
            else if(optionString.compareTo("3") == 0) {
                System.out.println("Please input the item you want to remove.");
                String title = userInput.nextLine();

                Media m = cart.searchByTitle(title);
                cart.removeMedia(m);
            }
            else if(optionString.compareTo("4") == 0) {
                System.out.println("Please type in the title you want to play."); 

                String titleString = userInput.nextLine();
                Media m = cart.searchByTitle(titleString);

                if(m != null) {
                    m.play();
                }

                else System.out.println("This item doesn't exist, please check again.");
            }
            else if(optionString.compareTo("5") == 0) {
                cart.placeOrder();
            }
        }

        }
    



public static void showMenu() {

    System.out.println("AIMS: ");
    
    System.out.println("--------------------------------");
    
    System.out.println("1. View store");
    
    System.out.println("2. Update store");
    
    System.out.println("3. See current cart");
    
    System.out.println("0. Exit");
    
    System.out.println("--------------------------------");
    
    System.out.println("Please choose a number: 0-1-2-3");
    
    }

public static void storeMenu() {
    System.out.println("Options: ");
            
            System.out.println("--------------------------------");

            System.out.println("1. See a media’s details");

            System.out.println("2. Add a media to cart");
            
            System.out.println("3. Play a media");

            System.out.println("4. See current cart");

            System.out.println("0. Back");

            System.out.println("--------------------------------");

            System.out.println("Please choose a number: 0-1-2-3-4");
}
public static void mediaDetailsMenu(Media m) {

    System.out.println("Options: ");
    
    System.out.println("--------------------------------");
    
    System.out.println("1. Add to cart");
    
    if(m instanceof CompactDisc || m instanceof DigitalVideoDisc) System.out.println("2. Play");
    
    System.out.println("0. Back");
    
    System.out.println("--------------------------------");
    
    if(m instanceof CompactDisc || m instanceof DigitalVideoDisc) System.out.println("Please choose a number: 0-1");
    else System.out.println("Please choose a number: 0-1-2");
    
    }
    public static void cartMenu() {

        System.out.println("Options: ");
        
        System.out.println("--------------------------------");
        
        System.out.println("1. Filter media in cart");
        
        System.out.println("2. Sort media in cart");
        
        System.out.println("3. Remove media from cart");
        
        System.out.println("4. Play a media");
        
        System.out.println("5. Place order");
        
        System.out.println("0. Back");
        
        System.out.println("--------------------------------");
        
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        
        }
}