package components;

import utilities.CustomFontLoader;
import utilities.IconImage;

import javax.swing.*;
import java.awt.*;

public class MoneyDisplay extends JPanel {
    private final Font jerseyFont = CustomFontLoader.loadCustomFont("resources/Jersey10.ttf");;

    public MoneyDisplay() {
        // DISPLAY Configuration //
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        setBackground(Color.orange);

        // MONEY_LABEL Configuration //
        JLabel moneyLabel = new JLabel("Money");
        ImageIcon icon = IconImage.create("resources/images/Money.png", 20, 20); // Icon for JLabel
        moneyLabel.setFont(jerseyFont);
        moneyLabel.setIcon(icon);

        add(moneyLabel);
    }
}