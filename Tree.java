
// healthy tree that can catch fire from neighbors
 
public class Tree extends Plant {
   
   public Tree() {
      super("tree");
   }
   
   public void catchFire() {
      setStatus("burning");
   }
   
   public void update(Forest forest, int row, int col) {
      int totalRows = forest.getRows();
      int totalCols = forest.getCols();
      
      // up check
      if (row - 1 >= 0) {
         if (forest.getCell(row - 1, col).isBurning()) {
            double chance = Math.random();
            if (chance < 0.4) {
               forest.setOnFire(row, col);
               return;
            }
         }
      }
      // check down
      if (row + 1 < totalRows) {
         if (forest.getCell(row + 1, col).isBurning()) {
            double chance = Math.random();
            if (chance < 0.4) {
               forest.setOnFire(row, col);
               return;
            }
         }
      }
      //  left check
      if (col - 1 >= 0) {
         if (forest.getCell(row, col - 1).isBurning()) {
            double chance = Math.random();
            if (chance < 0.4) {
               forest.setOnFire(row, col);
               return;
            }
         }
      }
      //  right chek
      if (col + 1 < totalCols) {
         if (forest.getCell(row, col + 1).isBurning()) {
            double chance = Math.random();
            if (chance < 0.4) {
               forest.setOnFire(row, col);
               return;
            }
         }
      }
   }
}