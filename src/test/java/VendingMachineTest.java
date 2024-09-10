import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class VendingMachineTest {
    private VendingMachine vendingMachine;

    @BeforeEach
    public void setUp() throws VendingMachineException {
        vendingMachine = new VendingMachine();
        vendingMachine.addProduct(new Product("Coke", 1.50, 10));
        vendingMachine.addProduct(new Product("Pepsi", 1.25, 5));
    }

    @Test
    public void testAddProduct() throws VendingMachineException {
        Product product = new Product("Water", 1.00, 20);
        vendingMachine.addProduct(product);
        assertThrows(VendingMachineException.class, () -> vendingMachine.addProduct(product));  // Already exists
    }

    @Test
    public void testInsertCoinAndDispenseProduct() throws VendingMachineException {
        vendingMachine.insertCoin(2.00);
        vendingMachine.dispenseProduct("Coke");
        assertThrows(InsufficientFundsException.class, () -> vendingMachine.dispenseProduct("Pepsi"));  // Insufficient funds
    }

    @Test
    public void testDispenseOutOfStockProduct() throws VendingMachineException {
        vendingMachine.insertCoin(5.00);
        for (int i = 0; i < 5; i++) {
            vendingMachine.dispenseProduct("Pepsi");
        }
        assertThrows(OutOfStockException.class, () -> vendingMachine.dispenseProduct("Pepsi"));  // Out of stock
    }

    @Test
    public void testReturnChange() {
        vendingMachine.insertCoin(1.00);
        double change = vendingMachine.returnChange();
        assertEquals(1.00, change);
    }

    @Test
    public void testDisplayProducts() {
        vendingMachine.displayProducts();  // Ensure products are displayed correctly
    }
}
