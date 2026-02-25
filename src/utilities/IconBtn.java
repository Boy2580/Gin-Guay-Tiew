package utilities;

import utilities.IconImage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IconBtn extends JButton {
    ImageIcon btnImage;
    ImageIcon btnImage_Hover;
    ImageIcon btnImage_Clicked;
    public IconBtn(String label, String btnImagePath, String btnImageType, float fontSize) {

        super(label);
        btnImage = IconImage.create(btnImagePath+btnImageType, 250, 50);
        btnImage_Hover = IconImage.create(btnImagePath+"_Hover"+btnImageType, 250, 50);
        btnImage_Clicked = IconImage.create(btnImagePath+"_Clicked"+btnImageType, 250, 50);
        setIcon(btnImage);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);

        Font jerseyFont = CustomFontLoader.loadCustomFont("resources/Jersey10.ttf");
        setFont(jerseyFont.deriveFont(16f));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setIcon(btnImage_Hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setIcon(btnImage);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setIcon(btnImage_Clicked);
            }
        });
    }
}