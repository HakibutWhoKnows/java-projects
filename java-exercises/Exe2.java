import acm.program.ConsoleProgram;

public class Exe2 extends ConsoleProgram {

    public void run() {
        int width = readInt("Enter width of diamond: ");

        if (width % 2 == 0) {
            println("Width must be an odd number. Please try again.");
            return;
        }

        int halfWidth = width / 2;

        // Top half including the middle row
        for (int i = 0; i <= halfWidth; i++) {
            // Print stars before the first space
            for (int j = 0; j < halfWidth - i; j++) {
                print("*");
            }
            // Print the first space
            print(" ");
            // Print the inner spaces and another space if not the first row
            if (i > 0) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    print(" ");
                }
                print(" ");
            }
            // Print stars after the spaces
            for (int j = 0; j < halfWidth - i; j++) {
                print("*");
            }
            println();
        }

        // Bottom half
        for (int i = halfWidth - 1; i >= 0; i--) {
            // Print stars before the first space
            for (int j = 0; j < halfWidth - i; j++) {
                print("*");
            }
            // Print the first space
            print(" ");
            // Print the inner spaces and another space if not the first row
            if (i > 0) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    print(" ");
                }
                print(" ");
            }
            // Print stars after the spaces
            for (int j = 0; j < halfWidth - i; j++) {
                print("*");
            }
            println();
        }
    }
}
