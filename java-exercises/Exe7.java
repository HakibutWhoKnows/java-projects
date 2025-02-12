import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Exe7 extends GraphicsProgram {

    public void run() {
        final int NROWS = 8;
        final int NCOLUMNS = 8;
        final int SQUARE_SIZE= 40;

        // Calculate the starting x and y coordinates for centering the checkerboard
        int boardWidth = NCOLUMNS * SQUARE_SIZE;
        int boardHeight = NROWS * SQUARE_SIZE;
        int startX = (getWidth() - boardWidth) / 2;
        int startY = (getHeight() - boardHeight) / 2;
        final double SQ_SIDE = (double) getHeight() / SQUARE_SIZE;
        for (int row = 0; row < NROWS; row++) {
            for (int col = 0; col < NCOLUMNS; col++) {  //to determine the position of each square.
                int x = startX + col * SQUARE_SIZE;
                int y = startY + row * SQUARE_SIZE;

                // Create and color the square
                GRect square = new GRect(x, y, SQUARE_SIZE, SQUARE_SIZE);
                square.setFilled(true);
                if ((row + col) % 2 == 0) {
                    square.setColor(Color.WHITE);
                } else {
                    square.setColor(Color.GRAY);
                }
                add(square);

                // draws lines around each square  top, bottom, left, and right
                GLine topLine = new GLine(x, y, x + SQUARE_SIZE, y);
                GLine bottomLine = new GLine(x, y + SQUARE_SIZE, x + SQUARE_SIZE, y + SQUARE_SIZE);
                GLine leftLine = new GLine(x, y, x, y + SQUARE_SIZE);
                GLine rightLine = new GLine(x + SQUARE_SIZE, y, x + SQUARE_SIZE, y + SQUARE_SIZE);
                add(topLine);
                add(bottomLine);
                add(leftLine);
                add(rightLine);

                if ((row + col) % 2 != 0) {
                    if (row < 3) { //  // black checkers in the first three rows
                        GOval checker = new GOval(x + 4, y + 4, SQUARE_SIZE - 8, SQUARE_SIZE - 8);
                        checker.setFilled(true);
                        checker.setColor(Color.BLACK);
                        add(checker);
                    } else if (row > 4) { // red checkers  placed in the last three rows.
                        GOval checker = new GOval(x + 4, y + 4, SQUARE_SIZE - 8, SQUARE_SIZE - 8);
                        checker.setFilled(true);
                        checker.setColor(Color.RED);
                        add(checker);
                    }
                }
            }
        }
    }
}
