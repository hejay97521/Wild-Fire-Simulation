
// base class for the grid
 
public abstract class Cell {
   
   private String status;
   
   public Cell(String status) {
      this.status = status;
   }
   
   public String getStatus() {
      return status;
   }
   
   public void setStatus(String s) {
      status = s;
   }
   
   public boolean isBurning() {
      if (status.equals("burning")) {
         return true;
      }
      return false;
   }
   
   public abstract void update(Forest forest, int row, int col);
   
   //temp
   
}
 