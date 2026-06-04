
// BurningTree.java - a tree that is on fire, turns to ash after a few steps
 
public class BurningTree extends Plant {
   
   private int stepsBurning;
   
   public BurningTree() {
        super("burning");
        stepsBurning = 0;
       //NOT DONE
       //set stepsburning to = and super "burning")
       
   }
   
   public void update(Forest forest, int row, int col) {
        stepsBurning++;
        if (stepsBurning >= 3) {
            forest.setOnFire(row, col);
        }
       //NOT DONE
       // stepsburning+1
       //if its burning over or equal 3, set forest ash to row, col
 
   }
}
