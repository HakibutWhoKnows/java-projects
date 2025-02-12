import acm.program.ConsoleProgram;

public class Exe4 extends ConsoleProgram {
    public void run(){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        final int Sentinel = 0;

        while(true){
            int num = readInt("enter a number : ");

            if (num < smallest && num != Sentinel){ //when number is smaller than current smallest and num is not equal to 0
                smallest = num;
            }
            if (num > largest){  //when number is larger than the current largest
                largest = num;
            } else if (num == smallest && num == largest){
               println("smallest : " + num);
               println("largest : " + num);
            } else if (num == Sentinel){
                println("No largest or smallest to be chosen since you have entered no values");
                break;
            }
            println("smallest " + smallest);
            println("largest " + largest);
        }

    }
}
