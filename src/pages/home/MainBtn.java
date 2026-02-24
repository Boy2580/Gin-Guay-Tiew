package pages.home;

import components.MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainBtn implements ActionListener {

    private JDialog dialog;

    public MainBtn(){
        this(null);
    }

    public MainBtn(JDialog dialog) {
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Start Game")){
            System.out.println("Start Game");
        }
        if (e.getActionCommand().equals("Tutorial")){
            dialog.setVisible(true);
        }
        if (e.getActionCommand().equals("Shop")){
            System.out.println("Shop");
        }
        if (e.getActionCommand().equals("Setting")){
            System.out.println("Setting");
        }
        if (e.getActionCommand().equals("Exit")){
            System.out.println("Exit");
        }
    }
}
