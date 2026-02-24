package pages.home;

import pages.MainFrame;
import utilities.IconImage;
import components.MainMenu;
import javax.swing.*;
import java.awt.*;

import static javax.swing.BoxLayout.Y_AXIS;

public class MainMenuPage extends JPanel {

    MainFrame frame;
    private Image backgroundImage;

    JButton yes = new JButton("Yes");
    JButton no = new JButton("No");
    JDialog dialog;

    JLabel logo = new JLabel();
    JButton start_game = new JButton("Start Game");
    JButton tutorial = new JButton("Tutorial");
    JButton shop = new JButton("Shop");
    JButton setting = new JButton("Setting");
    JButton exit = new JButton("Exit");

    public MainMenuPage(MainFrame frame) {

        this.frame = frame;
        setLayout(new BorderLayout());
        dialog = new PopupWindow().PopupTutorial(frame,"tutorial",true,"Do you want to play Tutorial",yes,no);
        this.backgroundImage = new ImageIcon("resources/images/mainMenu/image-from-rawpixel-id-14653376-jpeg.jpg").getImage();

        JPanel center_contain = new JPanel();
        center_contain.setLayout(new BoxLayout(center_contain,Y_AXIS));


        // Image LoGogame
        ImageIcon icon = IconImage.create("resources/images/mainMenu/LogoGame.png", 300, 300);
        JLabel con_icon = new JLabel();
        con_icon.setIcon(icon);
        con_icon.setAlignmentX(Component.CENTER_ALIGNMENT);
        center_contain.add(con_icon);
        center_contain.setOpaque(false);


        // -------------------------------------


        // GridButton, start_game, tutorial, shop, setting
        MainMenu setBtn = new MainMenu();
        JPanel con_Main_btn = new JPanel();
        con_Main_btn.setLayout(new GridLayout(2,2,10,10));
        con_Main_btn.setMaximumSize(new Dimension(500,35));
        con_Main_btn.setOpaque(false);

        start_game.setActionCommand("Start Game");
        tutorial.setActionCommand("Tutorial");
        shop.setActionCommand("Shop");
        exit.setActionCommand("Exit");
        setting.setActionCommand("Setting");

        setBtn.settingBtn(start_game,200,35);
        setBtn.settingBtn(tutorial,200,35);
        setBtn.settingBtn(shop,200,35);
        setBtn.settingBtn(setting,200,35);

        con_Main_btn.add(start_game);
        con_Main_btn.add(tutorial);
        con_Main_btn.add(shop);
        con_Main_btn.add(setting);

        center_contain.add(con_Main_btn);
        // -------------------------------------



        // Button Exit
        JPanel con_exit = new JPanel();
        setBtn.settingBtn(exit,500,35);
        con_exit.add(exit);
        con_exit.setBorder(BorderFactory.createEmptyBorder(5,0,0,0));
        center_contain.add(con_exit);
        con_exit.setOpaque(false);
        // -------------------------------------


        // ส่งค่าแต่ละปุ่มไปยัง class ปุ่มที่สร้างแยกไว้
        MainBtn action_btn = new MainBtn(dialog,frame);


        start_game.addActionListener(action_btn);
        tutorial.addActionListener(action_btn);
        shop.addActionListener(action_btn);
        exit.addActionListener(action_btn);
        setting.addActionListener(action_btn);



        add(center_contain, BorderLayout.CENTER);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    public JDialog getDialog() {
        return dialog;
    }
    }