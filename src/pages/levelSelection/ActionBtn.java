package pages.levelSelection;

import pages.MainFrame;
import java.awt.event.*;

public class ActionBtn implements ActionListener {
    private MainFrame frame;

    public ActionBtn(MainFrame frame) {
        if(frame == null) return;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Wat Plook")) {
            frame.getNavigator().toPage("winlose",true,500);
        }
    }
}
