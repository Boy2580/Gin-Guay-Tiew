package pages.endGame;

import pages.MainFrame;
import utilities.CustomFontLoader;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ShowMeTheMoney extends JPanel {
    private MainFrame mainFrame;
    private final Font jerseyFont = CustomFontLoader.loadCustomFont("resources/Jersey10.ttf");
    private double TotalMoney;

    private JPanel OrderPanel, TotalPanel;
    private JLabel Money, Bonus, Total;
    private JTextField moneyField, bonusField, totalField;

    public ShowMeTheMoney(MainFrame mainFrame,double moneyEarned, double bonusMoney) {
        this.mainFrame = mainFrame;
        this.TotalMoney = moneyEarned + bonusMoney;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setBorder(new EmptyBorder(15,100,15,100));
        Color panelColor = new Color(220, 220, 220);

        // Top Box
        OrderPanel = new JPanel();
        OrderPanel.setLayout(new GridLayout(2,2,15,10));
        OrderPanel.setBackground(panelColor);
        OrderPanel.setBorder(new EmptyBorder(5,10,5,10));
        Money = createLabel("Money",50f);
        moneyField = createTextField(moneyEarned,50f);
        OrderPanel.add(Money);
        OrderPanel.add(moneyField);
        Bonus = createLabel("Bonus",50f);
        bonusField = createTextField(bonusMoney,50f);
        OrderPanel.add(Bonus);
        OrderPanel.add(bonusField);


        // Bottom Box
        TotalPanel = new JPanel();
        TotalPanel.setLayout(new GridLayout(1,2,15,10));
        TotalPanel.setBackground(panelColor);
        TotalPanel.setBorder(new EmptyBorder(5,10,5,10));
        Total = createLabel("Total",55f);
        totalField = createTextField(TotalMoney,55f);
        TotalPanel.add(Total);
        TotalPanel.add(totalField);

        add(OrderPanel);
        add(TotalPanel);
    }

    // ฟังก์ชันสร้างข้อความด้านซ้าย (Money, Bonus, Total)
    private JLabel createLabel(String text, float fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(jerseyFont.deriveFont(fontSize));
        label.setForeground(Color.BLACK); // ตัวหนังสือสีดำ
        label.setHorizontalAlignment(SwingConstants.CENTER); // จัดตัวหนังสือตรงกลาง
        return label;
    }

    // ฟังก์ชันสร้างกล่องตัวเลขด้านขวา (0.00)
    private JTextField createTextField(double value, float fontSize) {
        String formattedValue = String.format("%.2f", value);

        JTextField textField = new JTextField(formattedValue);
        textField.setEditable(false);
        textField.setHorizontalAlignment(SwingConstants.CENTER);// ตัวเลขอยู่ตรงกลางกล่อง
        textField.setFont(jerseyFont.deriveFont(fontSize));

        // ตกแต่งให้เหมือนรูปเป๊ะๆ (กล่องสีขาว ไม่มีขอบดำ)
        textField.setBackground(Color.WHITE);
        textField.setForeground(Color.BLACK);
        textField.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2)); // ลบกรอบดำของ Windows ออก
        return textField;
    }
}
