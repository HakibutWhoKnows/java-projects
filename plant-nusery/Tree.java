public class Tree {
    String name;
    String season;
    double buyPrice;
    double sellPrice;
    int stock;

    public Tree(String name, String season, double buyPrice, double sellPrice, int stock){
        this.name = name;
        this.season = season;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.stock = stock;
    }

    public void updateStock(int quantity){
        this.stock += quantity;
    }
}




