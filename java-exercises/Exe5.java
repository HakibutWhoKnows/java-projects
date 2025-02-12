import acm.program.ConsoleProgram;

public class Exe5 extends ConsoleProgram {
    public void run(){
        while (true){
            double initialMiles = readDouble("Initial Miles : ");
            if (initialMiles < 0){
                println("bye");
                break;
            }

            double finalMiles = readDouble("Final Miles : ");
            double Gallons = readDouble("Gallons : ");

            double milesPerGallon = (finalMiles - initialMiles) / Gallons;
            println("Miles per Gallon : " + milesPerGallon);
        }
    }
}
