package Lab11;
import java.awt.*;

/**
 * grid cell state management
 */
public class Cell {

    // fields
    private boolean isAlive;

    /**
     * constructor
     */
    public Cell() {

        // initialize state
        this.isAlive = false;

    }

    /**
     * get function for cell state
     */
    public boolean isAlive() {

        return isAlive;

    }

    /**
     * set function for cell state
     * @param alive set cell state
     */
    public void setAlive(boolean alive) {

        this.isAlive = alive;

    }

    /**
     * toggles cell state (alive -> not alive or not alive -> alive)
     */
    public void toggleState() {

        isAlive = !isAlive;

    }

    /**
     * update grid cell
     * @param g object for coloring
     * @param x position on grid
     * @param y position on grid
     * @param size dimensions of cell
     */
    public void draw(Graphics g, int x, int y, int size) {

        // update color based off cell state
        g.setColor(isAlive ? Color.YELLOW : Color.GRAY);
        g.fillRect(x, y, size - 1, size - 1);

    }

}
