package components;

import javax.swing.*;
import java.awt.*;
import pages.MainFrame;

public class MainMenu {
    private MainFrame frame;

    public void settingBtn(JButton btn){
        settingBtn(btn,0,0);

    }
    public void settingBtn(JButton btn,int width, int high){
        btn.setFocusPainted(false);
        btn.setForeground(Color.GRAY);
        btn.setPreferredSize(new Dimension(width,high));
    }

}
