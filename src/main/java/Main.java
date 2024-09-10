
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws VendingMachineException {
        VendingMachine vendingMachine = new VendingMachine();
        Scanner sc = new Scanner(System.in);

        // Adding some products to the vending machine
        vendingMachine.addProduct(new Product("Soda", 1.50, 10));
        vendingMachine.addProduct(new Product("Chips", 1.00, 5));
        vendingMachine.addProduct(new Product("Candy", 0.75, 20));

        while (true) {
            System.out.println("\nVending Machine Menu:");
            System.out.println("1. Display Products");
            System.out.println("2. Buy Product");
            System.out.println("3. Exit");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    vendingMachine.displayProducts();
                    break;

                case 2:
                    System.out.println("Enter the product name:");
                    String productName = sc.nextLine();

                    try {
                        System.out.println("Enter amount inserted (in dollars):");
                        double amountInserted = sc.nextDouble();
                        sc.nextLine(); 
                        vendingMachine.buyProduct(productName, amountInserted);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Exiting Vending Machine.");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
