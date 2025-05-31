package hust.soict.hedspi.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.scene.layout.Border;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {
    JTextField directorField;
    JTextField lengthField;

    public AddDVDToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
        setSize(512, 384);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        setJMenuBar(new StoreManagerScreen(store).createMenuBar());
        JPanel panel = new JPanel(new GridLayout(6, 2));

        idField = new JTextField();
        titleField = new JTextField();
        categoryField = new JTextField();
        costField = new JTextField();
        directorField = new JTextField();
        lengthField = new JTextField();

        panel.add(new JLabel("ID: "));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);
        panel.add(new JLabel("Director:"));
        panel.add(directorField);
        panel.add(new JLabel("Length: "));
        panel.add(lengthField);

        add(panel, BorderLayout.CENTER);

        JButton btnAdd = new JButton("Add");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);

        add(buttonPanel, BorderLayout.SOUTH);
        
        addListener btnAddListener = new addListener();
        btnAdd.addActionListener(btnAddListener);

        setVisible(true);
    }


    private class addListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            addDVD();
        }
    }

    public void addDVD() {
        int Id = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String director = directorField.getText();
        int length = Integer.parseInt(lengthField.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(Id, title, category, director, length, cost);

        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this, "DVD added");

        idField.setText("");
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        directorField.setText("");
        lengthField.setText("");
    }
}
