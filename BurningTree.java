
//A tree that is on fire turns to ash after a few steps
 
public class BurningTree extends Plant {
   
   private int stepsBurning;
   
   public BurningTree() {
        super("burning");
        stepsBurning = 0;
 
   }
   
   public void update(Forest forest, int row, int col) {
        stepsBurning++;
        if (stepsBurning >= 3) {
            forest.setToAsh(row, col);
        }

   }
}
