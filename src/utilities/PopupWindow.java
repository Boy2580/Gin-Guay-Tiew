package utilities;

import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;

public class PopupWindow {

    private JDialog dialog;
    private JButton btn1;
    private JButton btn2;

    private final Font loadedFont =
            CustomFontLoader.loadCustomFont("resources/Jersey10.ttf");

    private final Color color = Color.BLACK;
    private final int borderWidth = 4;
    private final Border customBorder =
            BorderFactory.createLineBorder(color, borderWidth);

    /* ===================== BOUNCE EFFECT ===================== */

    private void showWithBounceEffect(JFrame frame) {
        System.out.println("test01");
        int targetWidth = 442;
        int targetHeight = 108;

        final double[] scale = {0.1};
        final double[] velocity = {0.15};

        final double spring = 0.08;
        final double damping = 0.75;

        Point frameCenter = frame.getLocationOnScreen();
        int centerX = frameCenter.x + frame.getWidth() / 2;
        int centerY = frameCenter.y + frame.getHeight() / 2;

        dialog.setSize(1, 1);
        dialog.setLocation(centerX, centerY);

        Timer timer = new Timer(16, null);

        timer.addActionListener(e -> {

            double force = (1 - scale[0]) * spring;
            velocity[0] += force;
            velocity[0] *= damping;
            scale[0] += velocity[0];

            int currentWidth = (int) (targetWidth * scale[0]);
            int currentHeight = (int) (targetHeight * scale[0]);

            dialog.setSize(currentWidth, currentHeight);
            dialog.setLocation(
                    centerX - currentWidth / 2,
                    centerY - currentHeight / 2
            );

            if (Math.abs(velocity[0]) < 0.01 && Math.abs(1 - scale[0]) < 0.01) {

                dialog.setSize(targetWidth, targetHeight);
                dialog.setLocation(
                        centerX - targetWidth / 2,
                        centerY - targetHeight / 2
                );

                timer.stop();
            }
        });

        timer.start();
        dialog.setVisible(true);
    }

    /* ===================== CREATE CONTENT ===================== */

    public JDialog createPopup(JFrame frame, String title, boolean modal, String text, String... buttonTexts) {

        if (frame == null)
            throw new IllegalArgumentException("Frame cannot be null");

        dialog = new JDialog(frame, title, modal);
        dialog.setUndecorated(true);

        JLabel question = new JLabel(text, SwingConstants.CENTER);

        if (loadedFont != null) {
            question.setFont(loadedFont.deriveFont(35f));
        } else {
            question.setFont(new Font("Arial", Font.BOLD, 20));
        }

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

        for (String text_btn : buttonTexts){
            JButton btn = new JButton(text_btn);
            btn.setPreferredSize(new Dimension(97,32));
            btnPanel.add(btn);
        }

        JPanel container = new JPanel(new GridLayout(2, 1));
        container.add(question);
        container.add(btnPanel);

        dialog.add(container);

        ((JComponent) dialog.getContentPane()).setBorder(customBorder);

        dialog.pack();
        showWithBounceEffect(frame);

        return dialog;
    }

    /* ===================== OPTIONAL GETTERS ===================== */
}