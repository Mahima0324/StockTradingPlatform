import java.time.LocalDateTime;

public class Transaction {
    private String type;
    private String stockSymbol;
    private int quantity;
    private double price;
    private LocalDateTime timestamp;

    public Transaction(String type, String stockSymbol, int quantity, double price) {
        this.type = type;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.price = price;
        this.timestamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return timestamp + " | " + type + " " + quantity + " of " + stockSymbol + " @ ₹" + price;
    }
}
