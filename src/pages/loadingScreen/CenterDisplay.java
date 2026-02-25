package pages.loadingScreen;

import utilities.IconImage;
import javax.swing.*;
import java.awt.*;

public class CenterDisplay extends JPanel {

    public CenterDisplay() {
        setLayout(new GridLayout(1, 3, 35, 0));
        setBorder(BorderFactory.createEmptyBorder(25, 50, 25, 50));
        setOpaque(false);

        String imgPath = "resources/images/shared/AppIcon.png";

        add(createImageFrame(imgPath));
        add(createImageFrame(imgPath));
        add(createImageFrame(imgPath));
    }

    private JLabel createImageFrame(String path) {
        ImageIcon icon = IconImage.create(path, 160, 275);
        JLabel label = new JLabel(icon);

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBackground(new Color(0, 255, 255, 100));
        label.setOpaque(true);
        return label;
    }
}