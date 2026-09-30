import java.util.Random;

public class Stock {
    private String symbol;
    private double price;
    private double volatility;

    public Stock(String symbol, double price, double volatility) {
        this.symbol = symbol;
        this.price = price;
        this.volatility = volatility;
    }

    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
    public double getVolatility() { return volatility; }

    public void updatePrice() {
        Random rand = new Random();
        double changePercent = (rand.nextDouble() * volatility) - (volatility / 2);
        price += price * changePercent;
        if (price < 1) price = 1; // prevent negative/zero price
    }

    @Override
    public String toString() {
        return symbol + " | Price: ₹" + String.format("%.2f", price) + " | Volatility: " + volatility;
    }
}
