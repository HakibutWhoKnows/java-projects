import acm.program.ConsoleProgram;

public class Exe1 extends ConsoleProgram {
    public void run(){
        println("Dice-1" + "\t" + "Dice-2");
        println("_______________________");
        //for dice 1
        for (int i = 0; i <= 6; i++) {
            //for dice 2
            for (int j = 0; j <= 6; j++) {
                println(i + "\t" + j);
            }
        }
    }
}
