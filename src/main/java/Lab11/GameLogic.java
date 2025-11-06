package Lab11;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class GameLogic {

    // components
    private final PropertyChangeSupport propertyChangeSupport;
    private Cell[][] cells;

    /**
     * constructor
     *
     * @param startingCells current cells in grid game
     */
    public GameLogic(Cell[][] startingCells) {

        // initialize components
        this.cells = startingCells;
        this.propertyChangeSupport = new PropertyChangeSupport(this);

    }

    /**
     * add listener for game grid updates
     *
     * @param listener object that receives events
     */
    public void addPropertyChangeListener(PropertyChangeListener listener) {

        propertyChangeSupport.addPropertyChangeListener(listener);

    }

    /**
     * apply game logic to grid game
     */
    public void updateGrid() {

        // get grid dimensions
        int rows = cells.length;
        int cols = cells[0].length;

        // create updated grid
        boolean[][] updatedCells = new boolean[rows][cols];

        // apply game logic
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                int neighbors = countAliveNeighbors(row, col);  // count neighbors
                boolean alive = cells[row][col].isAlive();  // current cell state

                if (alive) {  // cell is populated
                    // dies: neighbors <= 1 (solitude) or neighbors >= 4 (overpopulation)
                    // survives: neighbors == 2 or 3
                    updatedCells[row][col] = (neighbors == 2 || neighbors == 3);
                } else {  // cell is not populated
                    // populate cell if neighbors == 3
                    updatedCells[row][col] = (neighbors == 3);
                }

            }
        }

        // update cells
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col].setAlive(updatedCells[row][col]);
            }
        }

        propertyChangeSupport.firePropertyChange("grid", null, cells);

    }

    /**
     * counts number of neighbors by a given cell position
     * @param row cell position
     * @param col cell position
     * @return number of neighbors
     */
    private int countAliveNeighbors(int row, int col) {

        // config
        int count = 0;
        int rows = cells.length;
        int cols = cells[0].length;

        // count neighbors
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {

                // don't count cell's position
                if (r == row && c == col) {
                    continue;
                }

                // found alive neighbor
                if ((r >= 0) &&
                        (r < rows) &&
                        (c >= 0) &&
                        (c < cols) &&
                        (cells[r][c].isAlive())) {
                    count++;
                }
            }
        }

        return count;

    }

}



