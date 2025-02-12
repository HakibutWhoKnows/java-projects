import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Nursery nursery = new Nursery("FeedMe Plant Nursery", 1000.00);
        nursery.showMenu();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter your choice : ");
            char choice = sc.next().charAt(0);
            nursery.MenuChoice(choice);
        }
    }
}
