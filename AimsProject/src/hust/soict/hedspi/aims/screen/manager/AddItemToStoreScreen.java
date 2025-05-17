package hust.soict.hedspi.aims.screen.manager;

import javax.swing.JFrame;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.store.Store;

public class AddItemToStoreScreen extends JFrame {
    Store store;

     JTextField idField;
     JTextField titleField;
     JTextField categoryField;
     JTextField costField;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        addItem();
    }

    public void addItem() {
        
    }
}
