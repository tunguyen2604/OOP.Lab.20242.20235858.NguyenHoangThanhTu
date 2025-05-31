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
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.scene.layout.Border;

public class AddCDToStoreScreen extends AddItemToStoreScreen {
    JTextField artistField;
    JTextField tracksField;

    public AddCDToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
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
        artistField = new JTextField();
        tracksField = new JTextField();

        panel.add(new JLabel("ID: "));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);
        panel.add(new JLabel("Artist:"));
        panel.add(artistField);
        panel.add(new JLabel("Tracks: "));
        panel.add(tracksField);

        add(panel, BorderLayout.CENTER);

        JButton btnAdd = new JButton("Add");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }


    private class addListener implements ActionListener {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            addCD();
        }
    }

    public void addCD() {
        int Id = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String artist = artistField.getText();
        List<String> tracksTitle = new ArrayList<>(Arrays.asList(tracksField.getText().split(",")));        

        CompactDisc cd = new CompactDisc(Id, title, category, cost);
        cd.setArtist(artist);
        for(int i = 0; i < tracksTitle.size(); i++) {
            cd.addTrack(new Track(tracksTitle.get(i)));
        }

        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "CD added");

        idField.setText("");
        titleField.setText("");
        categoryField.setText("");
        costField.setText("");
        artistField.setText("");
        tracksField.setText("");
    }
}
