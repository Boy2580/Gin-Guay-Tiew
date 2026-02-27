package ui.pages.settingMenu;

import utilities.IconImage;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSetting implements ChangeListener, ActionListener {


    String path = "resources/images/settingMenu/tree";
    ImageIcon slider100 = IconImage.create(path+"100"+".png", 50, 50);
    ImageIcon slider75 = IconImage.create(path+"75"+".png", 50, 50);
    ImageIcon slider50 = IconImage.create(path+"50"+".png", 50, 50);
    ImageIcon slider25 = IconImage.create(path+"25"+".png", 50, 50);

    ImageIcon off = IconImage.create("resources/images/settingMenu/off.png", 90, 35);
    ImageIcon on = IconImage.create("resources/images/settingMenu/on.png", 90, 35);

    private JSlider slider;
    private JLabel label;
    private JButton btn;
    private boolean state =  true;

    public ButtonSetting(JButton btn){
        this.btn = btn;
    }
    public ButtonSetting(JSlider slider,JLabel label) {
        this.slider = slider;
        this.label = label;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == slider) {
            System.out.println("pop "+slider.getValue());
            if (slider.getValue() == 100) {
                label.setIcon(slider100);
            }
            else if (slider.getValue() >= 50) {
                label.setIcon(slider75);
            }
            else if (slider.getValue() >= 25) {
                label.setIcon(slider50);
            }
            else if (slider.getValue() >= 0) {
                label.setIcon(slider25);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("fx")){
            if (state){
                btn.setIcon(on);
                state = false;
            }
            else {
                btn.setIcon(off);
                state = true;
            }
        }
    }
}
