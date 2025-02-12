import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Exe6 extends GraphicsProgram {

    // Constants for the pyramid
    private static final int BRICK_WIDTH = 30;    // Width of each brick
    private static final int BRICK_HEIGHT = 12;   // Height of each brick
    private static final int BRICKS_IN_BASE = 14; // Number of bricks in the base

    public void run() {
        // Calculate the starting x and y coordinates
        int startX = (getWidth() - BRICK_WIDTH * BRICKS_IN_BASE) / 2;
        int startY = getHeight() - BRICK_HEIGHT;

        // Loop to draw each row of the pyramid
        for (int row = 0; row < BRICKS_IN_BASE; row++) {
            int bricksInRow = BRICKS_IN_BASE - row;
            int x = startX + (row * BRICK_WIDTH) / 2;
            int y = startY - row * BRICK_HEIGHT;

            //draw the rows
            for (int i = 0; i < bricksInRow; i++) {
                GRect brick = new GRect(x + i * BRICK_WIDTH, y, BRICK_WIDTH, BRICK_HEIGHT);
                add(brick);
            }
        }
    }
}
