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
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.scene.layout.Border;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    JTextField authorsField;

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");
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
        authorsField = new JTextField();

        panel.add(new JLabel("ID: "));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);
        panel.add(new JLabel("Authors:"));
        panel.add(authorsField);

        add(panel, BorderLayout.CENTER);

        JButton btnAdd = new JButton("Add");
        panel.add(btnAdd, BorderLayout.SOUTH);

        addListener btnAddListener = new addListener();
        btnAdd.addActionListener(btnAddListener);

        setVisible(true);
    }


    private class addListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            addBook();
        }
    }

    public void addBook() {
        int Id = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        List<String> authors = new ArrayList<>(Arrays.asList(authorsField.getText().split(",")));

        Book book = new Book(Id, title, category, cost);
        book.setAuthors(authors);

        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book added");

        idField.setText("");
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        authorsField.setText("");
    }
}
