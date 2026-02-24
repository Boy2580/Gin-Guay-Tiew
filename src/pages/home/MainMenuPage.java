package pages.home;

import pages.MainFrame;
import utilities.IconImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuPage extends JPanel implements ActionListener {

    MainFrame frame;
    JLabel logo = new JLabel();

    public MainMenuPage(MainFrame frame){
        this.frame = frame;
        setLayout(new FlowLayout());
        ImageIcon icon = IconImage.create("resources/images/Money.png", 20, 20);
        logo.setIcon(icon);

        add(logo);


    }

    public void actionPerformed(ActionEvent e){

    }
}
