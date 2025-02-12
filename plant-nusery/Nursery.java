import java.util.ArrayList;
import java.util.Scanner;

public class Nursery {
    String name;
    double balance;
    ArrayList<Tree> trees = new ArrayList<>();
    ArrayList<Transaction> transactionsCredit = new ArrayList<>();
    ArrayList<Transaction>transitionsDebit = new ArrayList<>();

    public Nursery(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    //selling tree to the user
    public void sellTrees(String type, int quantity, boolean isCredit) {
        for (Tree tree : trees) {
            if (tree.name.equals(type)) {
                if (tree.stock >= quantity) {
                    tree.updateStock(-quantity);
                    double amount = quantity * tree.sellPrice;
                    if (isCredit) {
                        transactionsCredit.add(new Transaction(amount, 4, "credit"));
                    } else {
                        balance += amount;
                    }
                } else {
                    System.out.println("Not enough stock.");
                }
                return;
            }
        }
        System.out.println("Tree type not found.");
    }


    //buying trees from the supplier
    public void buyTrees(String type, int quantity, boolean isCredit) {
        for (Tree tree : trees) {
            if (tree.name.equals(type)) {
                Scanner sc = new Scanner(System.in);
                String season = sc.next();
                tree.season = season;
                tree.updateStock(quantity);
                double amount = quantity * tree.buyPrice;
                if (isCredit) {
                    transitionsDebit.add(new Transaction(amount, 4, "debit"));
                } else {
                    balance -= amount;
                }
                return;
            }
        }

        double defaultBuyPrice = 10.0;  // Example default buy price
        double defaultSellPrice = 20.0; // Example default sell price
        trees.add(new Tree(type, "", defaultBuyPrice, defaultSellPrice, quantity));
        double amount = quantity * defaultBuyPrice;
        if (isCredit) {
            transitionsDebit.add(new Transaction(amount, 4, "debit"));
        } else {
            balance -= amount;
        }

    }

    //displaying the stock
    public void displayStock() {
        boolean hasStock = false;
        for (Tree tree : trees) {
            if (tree.stock > 0) {
                hasStock = true;
                System.out.println(tree.name + ": " + tree.stock + " @ $" + tree.sellPrice);
            }
        }

        if (!hasStock) {
            System.out.println("There is no stock currently! Buy some trees!");
        }

    }


    //show the tree's details
    public void showTreeDetails(String type) {
        for (Tree tree : trees) {
            if (tree.name.equals(type)) {
                System.out.println("Tree: " + tree.name);
                System.out.println("Season: " + tree.season);
                System.out.println("Buy Price: $" + tree.buyPrice);
                System.out.println("Sell Price: $" + tree.sellPrice);
                System.out.println("Stock: " + tree.stock);
                return;
            }
        }
        System.out.println("Tree type not found.");
    }

    //calculating the capital
    public void calculateCapital(){
        double creditTotal = 0;
        for (Transaction t : transactionsCredit){
            if (t.delay == 0){
                creditTotal += t.amount;
            }
        }

        double debitTotal = 0;
        for (Transaction t : transitionsDebit){
            if (t.delay == 0){
                debitTotal += t.amount;
            }
        }

        double capital = balance + creditTotal - debitTotal;
        System.out.println("Bank Balance: $" + balance);
        System.out.println("Credit Total: $" + creditTotal);
        System.out.println("Debit Total: $" + debitTotal);
        System.out.println("Capital: $" + capital);
    }

    public void showMenu(){
        System.out.println("Menu:");
        System.out.println("S - Sell trees");
        System.out.println("B - Buy trees");
        System.out.println("D - Display stock");
        System.out.println("T - Show tree details");
        System.out.println("C - Show capital");
        System.out.println("E - Exit");
        System.out.println("? - Show menu");
    }

    //menu
    public void MenuChoice(char choice){
        Scanner sc = new Scanner(System.in);
        switch(choice){
            case'S':
                System.out.print("Enter tree type : ");
                String sellType = sc.next();
                System.out.print("Enter quantity : ");
                int sellQty = sc.nextInt();
                System.out.print("Is this a credit transaction? (true/false) : ");
                boolean isSellCredit = sc.nextBoolean();
                sellTrees(sellType, sellQty, isSellCredit);
                break;
            case 'B':
                System.out.print("Enter tree type : ");
                String buyType = sc.next();
                System.out.print("Enter tree season : ");
                String season = sc.next();
                System.out.print("Enter quantity : ");
                int buyQty = sc.nextInt();
                System.out.print("Is this a credit transaction? (true/false) : ");
                boolean isBuyCredit = sc.nextBoolean();
                buyTrees(buyType, buyQty, isBuyCredit);
                break;
            case 'D':
                displayStock();
                break;
            case 'T':
                System.out.print("Enter tree type: ");
                String treeType = sc.next();
                showTreeDetails(treeType);
                break;
            case 'C':
                calculateCapital();
                break;
            case 'E':
                System.exit(0);
                break;
            case '?':
                showMenu();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
