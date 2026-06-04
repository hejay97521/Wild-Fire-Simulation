// represents empty ground, cannot catch fire
 
public class Empty extends Cell {
   
   public Empty() {
      super("empty");
   }
   
   public void update(Forest forest, int row, int col) {
      // empty ground does not do anything
   }
}