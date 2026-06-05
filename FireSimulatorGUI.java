//Confirm working?
import java.awt.*;
import javax.swing.*;

public class FireSimulatorGUI {
   
   private static final int ROWS = 40;
   private static final int COLS = 40;
   private static final double DENSITY = 0.7;
   private static final int CELL_SIZE = 15;
   private static final int DELAY = 300;
   
   private Forest forest;
   private DrawingPanel panel;
   
   public FireSimulatorGUI() {
      forest = new Forest(ROWS, COLS, DENSITY);
      forest.setOnFire(ROWS / 2, COLS / 2);
      
      int width = COLS * CELL_SIZE;
      int height = ROWS * CELL_SIZE;
      panel = new DrawingPanel(width, height);
      
      draw(panel.getGraphics());
      
      Timer timer = new Timer(DELAY, e -> step());
      timer.start();
   }
   
   private void step() {
      forest.update();
      draw(panel.getGraphics());
      panel.sleep(0);
   }
   
   private void draw(Graphics g) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                String status = forest.getCell(r, c).getStatus();
                if (status.equals("tree"))         g.setColor(new Color(34, 139, 34));
                else if (status.equals("burning")) g.setColor(Color.ORANGE);
                else if (status.equals("ash"))     g.setColor(Color.GRAY);
                else                               g.setColor(new Color(210, 180, 140));
                g.fillRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }
   
    public void reset() {
        forest = new Forest(ROWS, COLS, DENSITY);
        forest.setOnFire(ROWS / 2, COLS / 2);
        draw(panel.getGraphics());
    }
   
    public void startUp() {
        Timer timer = new Timer(DELAY, e -> step());
        timer.start();
    }
   
    public static void main(String[] args) {
        new FireSimulatorGUI();
    }
}
