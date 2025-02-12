import acm.program.ConsoleProgram;

public class Exe3 extends ConsoleProgram {
    public void run() {
        // Get user inputs
        double totalAmount = readDouble("Enter the total amount: ");
        double monthlyPayment = readDouble("Enter monthly payment: ");
        double monthlyInterestRate = readDouble("Enter rate in %: ");
        monthlyInterestRate = monthlyInterestRate/ 100; //4.5/100

        double balance = totalAmount;  //2000
        int month = 1;
        double totalPaid = 0;

        // Loop until balance is paid off
        while (balance > 0) {  //2000 > 0
            double interest = balance * monthlyInterestRate;  //2000 * 4.5

            double payment;
            if (balance + interest <= monthlyPayment) {
                payment = balance + interest;
            } else {
                //paid off
                payment = monthlyPayment;

            }

            balance = balance + interest - payment;
            totalPaid += payment;

            // Print details for the current month
            println("Month : " + month + "       " + "Balance : " + balance + "       " +  "Paid : " + totalPaid);

            //incrementing the month
            month++;
        }
    }
}
