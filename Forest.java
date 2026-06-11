//  grid of Cell objects and manages simulation state.
// updates all cells each step and handles fire/ash transitions.
//STILL WORKING
public class Forest {

    private Cell[][] grid;
    private int rows;
    private int cols;


    // random places trees
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
   
            grid[row][col] = new BurningTree();
      
    }
    public void setToAsh(int row, int col){
        grid[row][col] = new Ash();
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


    // advances simulation by each time
    public void update() {
        boolean[][] catchFire = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c].getStatus().equals("burning")) {
                    grid[r][c].update(this, r, c);
                } else if (grid[r][c].getStatus().equals("tree")) {
                    if (r - 1 >= 0 && grid[r-1][c].isBurning()) {
                        if (Math.random() < 0.4) catchFire[r][c] = true;
                    }
                    if (r + 1 < rows && grid[r+1][c].isBurning()) {
                        if (Math.random() < 0.4) catchFire[r][c] = true;
                    }
                    if (c - 1 >= 0 && grid[r][c-1].isBurning()) {
                        if (Math.random() < 0.4) catchFire[r][c] = true;
                    }
                    if (c + 1 < cols && grid[r][c+1].isBurning()) {
                        if (Math.random() < 0.4) catchFire[r][c] = true;
                    }
                }
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (catchFire[r][c]) {
                    grid[r][c] = new BurningTree();
                }
            }
        }
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
