package ui.pages.shopUI;

import javax.swing.*;
import java.awt.*;
import logic.GameController;
import logic.UpgradeItem;
import ui.components.BackBtn;
import ui.components.MoneyDisplay;
import ui.components.PopupWindow;
import main.MainFrame; // อย่าลืม import MainFrame มาด้วย

public class ShopScreen extends JPanel {
    private GameController controller;

    public ShopScreen(GameController gm) {
        this.controller = gm;
        setLayout(new BorderLayout());

        // 1. ส่วนบน (North)
        JPanel northPanel = new JPanel(new BorderLayout());

        // แก้ไข: ส่งค่าตามที่ BackBtn ต้องการ
        JButton backBtn = new BackBtn(gm.getMainFrame(), MainFrame.MAIN_MENU);

        northPanel.add(backBtn, BorderLayout.WEST);

        // แก้ไข: ส่งค่าเงินจริงให้ MoneyDisplay
        northPanel.add(new MoneyDisplay(gm.getTotalMoney()), BorderLayout.EAST);
        add(northPanel, BorderLayout.NORTH);

        // 2. ส่วนกลาง (Center)
        JPanel gridPanel = new JPanel(new GridLayout(0, 2, 10, 10));

        for (UpgradeItem item : gm.getAvailableItems()) {
            gridPanel.add(createItemCard(item));
        }

        JScrollPane scrollPane = new JScrollPane(gridPanel);
        add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createItemCard(UpgradeItem item) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBorder(BorderFactory.createEtchedBorder());

        JLabel nameLabel = new JLabel(item.getName() + " (" + item.getPrice() + " N)");
        JButton buyBtn = new JButton("BUY");

        if (controller.getTotalMoney() < item.getPrice()) {
            buyBtn.setBackground(Color.RED);
            buyBtn.setForeground(Color.WHITE);
        }

        buyBtn.addActionListener(e -> {
            if (controller.purchaseItem(item)) {
                // ซื้อสำเร็จ: ทำการวาดหน้าจอใหม่ (Refresh)
                removeAll();
                add(new ShopScreen(controller));
                revalidate();
                repaint();
            } else {
                // เงินไม่พอ: เรียกใช้ PopupWindow ตามลอจิกของเพื่อน
                new PopupWindow().createPopup(
                        controller.getMainFrame(),
                        "Not enough money!",
                        "resources/images/shared/popups/Demo.png",
                        new String[]{"resources/images/shared/buttons/Ok"},
                        new String[]{"No"},
                        null
                );
            }
        });

        card.add(nameLabel, BorderLayout.CENTER);
        card.add(buyBtn, BorderLayout.EAST);
        return card;
    }
}