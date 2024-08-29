package ObjectOrientedPrograms;
import java.util.Scanner;

import java.util.ArrayList;

class Stock{
    String stockName;
    int numberOfShares;
    double sharePrice;

    public Stock(String stockName,int numberOfShares,double sharePrice){
        this.stockName=stockName;
        this.numberOfShares=numberOfShares;
        this.sharePrice=sharePrice;
    }

    double calculateValue(){
        return numberOfShares*sharePrice;
    }
    String getName(){
        return stockName;
    }
    int getNumberOfShares(){
        return numberOfShares;
    }
    double getSharePrice(){
        return sharePrice;
    }

}
class StockPortfolio{
    private ArrayList<Stock> stocks;

    public StockPortfolio(){
        this.stocks=new ArrayList<>();
    }
    public void addStock(Stock stock){
        stocks.add(stock);

    }

    public double calculateValue(){
        double totalValue=0;
        for(Stock stock : stocks){
            totalValue+=calculateValue();
        }
        return  totalValue;
    }
    public void printReport() {
        System.out.println("Stock Report:");
        for (Stock stock : stocks) {
            System.out.printf("%s: %d shares at $%.2f each, Total Value: $%.2f\n",
                    stock.getName(), stock.getNumberOfShares(),
                    stock.getSharePrice(), stock.calculateValue());
        }
        System.out.println("-------------------------");
        System.out.printf("Total Stock Portfolio Value: $%.2f\n", calculateValue());
    }
}



public class StockAccountManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a StockPortfolio object
        StockPortfolio portfolio = new StockPortfolio();

        // Read in the number of stocks
        System.out.print("Enter the number of stocks: ");
        int numberOfStocks = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Loop to read in each stock's details
        for (int i = 0; i < numberOfStocks; i++) {
            System.out.println("Enter details for Stock " + (i + 1) + ":");

            System.out.print("Enter stock name: ");
            String name = scanner.nextLine();

            System.out.print("Enter number of shares: ");
            int numberOfShares = scanner.nextInt();

            System.out.print("Enter share price: ");
            double sharePrice = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline

            // Create a new Stock object and add it to the portfolio
            Stock stock = new Stock(name, numberOfShares, sharePrice);
            portfolio.addStock(stock);
        }

        // Print the stock report
        portfolio.printReport();

        scanner.close();
    }
}
