package Lab11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * center panel where game takes place
 */
public class GridPanel extends JPanel implements PropertyChangeListener {

    // components
    private final int rows;
    private final int cols;
    private final int cellSize = 20;
    private final Cell[][] cells;

    /**
     * constructor
     * @param rows # of rows for grid game
     * @param cols # of columns for grid game
     */
    public GridPanel(int rows, int cols) {

        // initialize game dimensions
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];

        // initialize cells
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell();
            }
        }

        // config
        setBackground(Color.DARK_GRAY);

        // handle mouse events
        addMouseListener(new MouseAdapter() {

            /**
             * trigger event on mouse click --> color cell yellow and update state
             * @param e the event to be processed
             */
            @Override
            public void mouseClicked(MouseEvent e) {

                // get cell
                int col =  e.getX() / cellSize;
                int row = e.getY() / cellSize;

                // check if mouse click is within grid game
                if (row >= 0 && row < rows && col >= 0 && col < cols) {
                    cells[row][col].toggleState();
                    repaint();
                }
            }
        });

    }

    /**
     * clear grid game
     */
    public void clearGrid() {

        // clear cell states
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.setAlive(false);
            }
        }

        // clear grid colors
        repaint();

    }

    /**
     * trigger property change (TODO)
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        repaint();
    }

    /**
     * create game grid
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {

        // draw grid
        super.paintComponent(g);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * cellSize;
                int y = row * cellSize;
                cells[row][col].draw(g, x, y, cellSize);
            }
        }

    }

}
