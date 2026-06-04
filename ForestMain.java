
// tests the forest grid with text output
 
public class ForestMain {
   
   public static void main(String[] args) {
      Forest forest = new Forest(10, 10, 0.7); // changeable
      
      System.out.println("Initial grid:");
      System.out.println(forest);
      
      forest.setOnFire(5, 5);
      System.out.println("After setting fire at (5, 5):"); //changeable
      System.out.println(forest);
      
      forest.update();
      System.out.println("After step 1:");
      System.out.println(forest);
      
      forest.update();
      System.out.println("After step 2:");
      System.out.println(forest);
   }
}