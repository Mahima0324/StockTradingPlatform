import java.util.*;

public class TradingPlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockMarket market = new StockMarket();
        User user = new User("Mahima", 10000);

        while (true) {
            System.out.println("\n=== Stock Trading Platform ===");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    market.updatePrices();
                    market.displayMarket();
                    break;
                case 2:
                    market.displayMarket();
                    System.out.print("Enter stock symbol: ");
                    String buySymbol = sc.next();
                    System.out.print("Enter quantity: ");
                    int buyQty = sc.nextInt();
                    if (market.getStocks().containsKey(buySymbol)) {
                        user.buyStock(market.getStocks().get(buySymbol), buyQty);
                    } else {
                        System.out.println("❌ Invalid stock!");
                    }
                    break;
                case 3:
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = sc.next();
                    System.out.print("Enter quantity: ");
                    int sellQty = sc.nextInt();
                    if (market.getStocks().containsKey(sellSymbol)) {
                        user.sellStock(market.getStocks().get(sellSymbol), sellQty);
                    } else {
                        System.out.println("❌ Invalid stock!");
                    }
                    break;
                case 4:
                    System.out.println("\n=== Portfolio ===");
                    System.out.println("Balance: ₹" + user.getBalance());
                    for (String symbol : user.getPortfolio().keySet()) {
                        System.out.println(symbol + " : " + user.getPortfolio().get(symbol));
                    }
                    System.out.println("Total Value: ₹" + user.portfolioValue(market.getStocks()));
                    break;
                case 5:
                    System.out.println("\n=== Transactions ===");
                    for (Transaction t : user.getTransactions()) {
                        System.out.println(t);
                    }
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
