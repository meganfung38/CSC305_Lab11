package Lab11;
import javax.swing.*;
import java.awt.*;

/**
 * title panel
 */
public class InfoPanel extends JPanel {

    /**
     * constructor
     */
    public InfoPanel() {

        // config + title creation
        setBackground(Color.BLUE);
        JLabel title = new JLabel("Game of Life By Megan Fung");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        add(title);

    }
}
