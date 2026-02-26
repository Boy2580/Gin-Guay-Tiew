package ui.pages.levelSelection;

import ui.components.BackBtn;
import ui.components.MoneyDisplay;
import main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopBar extends JPanel {

    public TopBar(MainFrame mainFrame) {

        // TopPanel
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 55)); // Padding :3
        setOpaque(false);

        // Components
        JButton backBtn = new BackBtn();
        JPanel moneyDisplay = new MoneyDisplay();

        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getNavigator().toPage("mainMenu", true);
            }
        });

        add(backBtn, BorderLayout.WEST);
        add(moneyDisplay, BorderLayout.EAST);
    }
}