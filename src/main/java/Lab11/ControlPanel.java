package Lab11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * unifies all grid game controls
 */
public class ControlPanel extends JPanel implements ActionListener {

    // components
    private final JButton explanation, lexicon, start, next, clear;
    private final GridPanel gridPanel;
    private final GameLogic gameLogic;

    /**
     * constructor
     * @param gridPanel reference to gridPanel for button controls
     * @param gameLogic reference to gameLogic to update grid game
     */
    public ControlPanel(GridPanel gridPanel, GameLogic gameLogic) {

        // config
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        // initialize components
        this.gridPanel = gridPanel;
        this.gameLogic = gameLogic;
        explanation = new JButton("Explanation");
        lexicon = new JButton("Lexicon");
        start = new JButton("Start");
        next = new JButton("Next");
        clear = new JButton("Clear");

        // button config
        clear.addActionListener(this);
        next.addActionListener(this);

        // add to panel
        add(explanation);
        add(lexicon);
        add(start);
        add(next);
        add(clear);

    }

    /**
     * trigger events for controls
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {

        Object buttonPressed = e.getSource();

        // configure button events
        if (buttonPressed == clear) {
            gridPanel.clearGrid();
        } else if (buttonPressed == next) {
            gameLogic.updateGrid();
        }

    }
}
