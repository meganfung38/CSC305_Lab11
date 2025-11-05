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
    private JButton explanation, lexicon, start, next, clear;
    private GridPanel gridPanel;

    /**
     * constructor
     * @param gridPanel reference to gridPanel for button controls
     */
    public ControlPanel(GridPanel gridPanel) {

        // config
        setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));

        // initialize components
        this.gridPanel = gridPanel;
        explanation = new JButton("Explanation");
        lexicon = new JButton("Lexicon");
        start = new JButton("Start");
        next = new JButton("Next");
        clear = new JButton("Clear");

        // clear button config
        clear.addActionListener(this);

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

        // clear button
        if (e.getSource() == clear) {
            gridPanel.clearGrid();
        }

    }
}
