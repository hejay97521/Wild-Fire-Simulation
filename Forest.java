//  grid of Cell objects and manages simulation state.
// updates all cells each step and handles fire/ash transitions.
//STILL WORKING ON DO NOT MODIFY
public class Forest {

    private Cell[][] grid;
    private int rows;
    private int cols;

    public Forest(int rows, int cols, double density) {
        this.rows = rows;
        this.cols = cols;
        grid = new Cell[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                double roll = Math.random();
                if (roll < density) {
                    grid[r][c] = new Tree();
                } else {
                    grid[r][c] = new Empty();
                }
            }
        }
    }
//STILL WORKING
}