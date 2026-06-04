// Jayden He, Tuguldur Oyunjargal
// CS 142, Spring 2026
// Final Project: Wildfire Simulation
// FireSimulatorGUI.java - draws the forest grid and animates it using a timer

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
   }
   
//working on
}