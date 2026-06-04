//  grid of Cell objects and manages simulation state.
// updates all cells each step and handles fire/ash transitions.
//STILL WORKING
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
    public void setOnFire(int row, int col) {
        if (grid[row][col].getStatus().equals("tree")) {
            grid[row][col] = new BurningTree();
        } else if (grid[row][col].getStatus().equals("burning")) {
            grid[row][col] = new Ash();
        }
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void update() {
        Cell[][] next = new Cell[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                next[r][c] = grid[r][c];
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c].update(this, r, c);
            }
        }
        grid = next;
    }
    
    public String toString() {
        String result = "";
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                String s = grid[r][c].getStatus();
                if (s.equals("tree"))    result += "T ";
                else if (s.equals("burning")) result += "B ";
                else if (s.equals("ash"))     result += "A ";
                else                          result += ". ";
            }
            result += "\n";
        }
        return result;
    }
}
