package Lab11;
import javax.swing.*;
import java.awt.*;

/**
 * main frame unifying all components
 */
public class GameOfLifeFrame extends JFrame {

    // declare components
    private final GridPanel gridPanel;
    private final GameLogic gameLogic;
    private final ControlPanel controlPanel;
    private final InfoPanel infoPanel;

    /**
     * constructor
     */
    public GameOfLifeFrame() {

        // config
        super("Game of Life By Megan Fung");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        // initialize components
        gridPanel = new GridPanel(34, 40);
        gameLogic = new GameLogic(gridPanel.getCells());
        controlPanel = new ControlPanel(gridPanel, gameLogic);
        infoPanel = new InfoPanel();

        // add property change listener
        gameLogic.addPropertyChangeListener(gridPanel);

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
