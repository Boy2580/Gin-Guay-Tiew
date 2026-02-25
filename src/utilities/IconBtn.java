package utilities;

import javax.swing.*;
import java.awt.*;

public class IconBtn extends JButton {
    public IconBtn(String label, ImageIcon btnImage) {
        super(label, btnImage);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);

        Font jerseyFont = CustomFontLoader.loadCustomFont("resources/Jersey10.ttf");
        setFont(jerseyFont.deriveFont(16f));
    }

    public IconBtn(String label, ImageIcon btnImage, float fontSize) {
        super(label, btnImage);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
        setIconTextGap(20);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);

        Font jerseyFont = CustomFontLoader.loadCustomFont("resources/Jersey10.ttf");
        setFont(jerseyFont.deriveFont(fontSize));
    }
}