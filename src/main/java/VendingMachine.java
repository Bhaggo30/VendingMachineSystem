import java.util.HashMap;
import java.util.Map;

class VendingMachine {
    private Map<String, Product> products = new HashMap<>();
    private double currentBalance;

    public VendingMachine() {
        this.currentBalance = 0;
    }

    // Add product to inventory
    public void addProduct(Product product) throws VendingMachineException {
        if (products.containsKey(product.getName())) {
            throw new VendingMachineException("Product already exists in the vending machine.");
        }
        products.put(product.getName(), product);
    }

    // Accept coin input (add balance)
    public void insertCoin(double amount) {
        currentBalance += amount;
        System.out.println("Inserted: $" + amount + ". Current balance: $" + currentBalance);
    }

    // Dispense product based on selection
    public void dispenseProduct(String productName) throws VendingMachineException {
        Product product = products.get(productName);

        if (product == null) {
            throw new ProductNotFoundException("Product not found in the vending machine.");
        }

        if (currentBalance < product.getPrice()) {
            throw new InsufficientFundsException("Insufficient funds. Please insert more money.");
        }

        product.reduceQuantity();
        currentBalance -= product.getPrice();
        System.out.println("Dispensed: " + productName);
        System.out.println("Remaining balance: $" + currentBalance);
    }

    // Return change
    public double returnChange() {
        double change = currentBalance;
        currentBalance = 0;
        System.out.println("Returned change: $" + change);
        return change;
    }

    // Display available products
    public void displayProducts() {
        System.out.println("Available products:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    public void buyProduct(String productName, double amountInserted) {
    }
}
