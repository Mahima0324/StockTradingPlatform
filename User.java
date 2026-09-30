import java.util.*;

public class User {
    private String name;
    private double balance;
    private Map<String, Integer> portfolio;
    private List<Transaction> transactions;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.portfolio = new HashMap<>();
        this.transactions = new ArrayList<>();
    }

    public String getName() { return name; }
    public double getBalance() { return balance; }
    public Map<String, Integer> getPortfolio() { return portfolio; }
    public List<Transaction> getTransactions() { return transactions; }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (balance >= cost) {
            balance -= cost;
            portfolio.put(stock.getSymbol(), portfolio.getOrDefault(stock.getSymbol(), 0) + quantity);
            transactions.add(new Transaction("BUY", stock.getSymbol(), quantity, stock.getPrice()));
            System.out.println("✅ Bought " + quantity + " of " + stock.getSymbol());
        } else {
            System.out.println("❌ Not enough balance!");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        int owned = portfolio.getOrDefault(stock.getSymbol(), 0);
        if (owned >= quantity) {
            portfolio.put(stock.getSymbol(), owned - quantity);
            balance += stock.getPrice() * quantity;
            transactions.add(new Transaction("SELL", stock.getSymbol(), quantity, stock.getPrice()));
            System.out.println("✅ Sold " + quantity + " of " + stock.getSymbol());
        } else {
            System.out.println("❌ Not enough shares to sell!");
        }
    }

    public double portfolioValue(Map<String, Stock> market) {
        double total = balance;
        for (String symbol : portfolio.keySet()) {
            total += portfolio.get(symbol) * market.get(symbol).getPrice();
        }
        return total;
    }
}
