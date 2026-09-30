import java.util.*;

public class StockMarket {
    private Map<String, Stock> stocks;

    public StockMarket() {
        stocks = new HashMap<>();
        stocks.put("TATA", new Stock("TATA", 500, 0.05));
        stocks.put("RELIANCE", new Stock("RELIANCE", 800, 0.04));
        stocks.put("INFY", new Stock("INFY", 1200, 0.03));
    }

    public Map<String, Stock> getStocks() { return stocks; }

    public void updatePrices() {
        for (Stock stock : stocks.values()) {
            stock.updatePrice();
        }
    }

    public void displayMarket() {
        System.out.println("\n=== Market Data ===");
        for (Stock stock : stocks.values()) {
            System.out.println(stock);
        }
    }
}
