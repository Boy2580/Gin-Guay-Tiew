package pages.loadingScreen;

import javax.swing.*;
import java.awt.*;

public class LoadingPage extends JPanel {

    public LoadingPage() {
        setLayout(new BorderLayout());
        setOpaque(true);

        add(new CenterDisplay(), BorderLayout.CENTER);
        add(new TipsLabel(), BorderLayout.SOUTH);
    }
}