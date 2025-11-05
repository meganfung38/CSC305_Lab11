package Lab11;
import javax.swing.*;
import java.awt.*;

/**
 * main frame unifying all components
 * TODO implement game logic
 */
public class GameOfLifeFrame extends JFrame {

    // declare components
    private GridPanel gridPanel;
    private ControlPanel controlPanel;
    private InfoPanel infoPanel;
    // private GameLogic gameLogic;

    /**
     * constructor
     */
    public GameOfLifeFrame() {

        // title
        super("Game of Life By Megan Fung");

        // config
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        // initialize components
        gridPanel = new GridPanel(34, 40);
        controlPanel = new ControlPanel(gridPanel);
        infoPanel = new InfoPanel();
        // gameLogic = new GameLogic();

        // add property change listener
        // gameLogic.addPropertyChangeListener(gridPanel);

        // add components to frame
        add(infoPanel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

    }

    /**
     * entry point
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameOfLifeFrame::new);
    }
}
