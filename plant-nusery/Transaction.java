public class Transaction {
    double amount;
    int delay;
    String type;

    public Transaction(double amount, int delay, String type){
        this.amount = amount;
        this.delay = delay;
        this.type = type;
    }

    public void ImplementTransaction(Nursery nursery){
        if (this.delay == 0){
            if (this.type.equals("credit")){
                nursery.balance += this.amount;
            }else if(this.type.equals("debit")){
                nursery.balance -= this.amount;
            }
        } else {
            this.delay--;
        }
    }
}
