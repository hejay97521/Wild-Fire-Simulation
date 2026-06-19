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
    private Timer timer;

    public FireSimulatorGUI() {

        forest = new Forest(ROWS, COLS, DENSITY);
        forest.setOnFire(ROWS / 2, COLS / 2);

        int width = COLS * CELL_SIZE;
        int height = ROWS * CELL_SIZE;
        panel = new DrawingPanel(width, height);

        draw(panel.getGraphics());

        timer = new Timer(DELAY, e -> step());
        timer.start();




        JFrame frame = new JFrame("Controls");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());


        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> reset());
        frame.add(resetButton);

        frame.pack();

        frame.setVisible(true);
    }

    private void step() {
        forest.update();
        draw(panel.getGraphics());
    }

    private void draw(Graphics g) {
        for (int r = 0; r < ROWS; r++) {

            for (int c = 0; c < COLS; c++) {

                String status = forest.getCell(r, c).getStatus();
                if (status.equals("tree"))         g.setColor(new Color(34, 139, 34));
                else if (status.equals("burning")) g.setColor(Color.RED);
                else if (status.equals("ash"))     g.setColor(Color.GRAY);
                else                               g.setColor(new Color(210, 180, 140));
                g.fillRect(c * CELL_SIZE, r * CELL_SIZE, CELL_SIZE, CELL_SIZE);
            }
        }
    }


    public void reset() {
        timer.stop();
        forest = new Forest(ROWS, COLS, DENSITY);
        forest.setOnFire(ROWS / 2, COLS / 2);
        draw(panel.getGraphics());
        timer = new Timer(DELAY, e -> step());
        timer.start();
    }


    public void startUp() {
        Timer timer = new Timer(DELAY, e -> step());
        timer.start();
    }



    public static void main(String[] args) {
        new FireSimulatorGUI();
    }
}
    }
}
