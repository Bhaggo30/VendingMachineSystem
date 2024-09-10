class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity() throws OutOfStockException {
        if (quantity <= 0) {
            throw new OutOfStockException("Product is out of stock.");
        }
        quantity--;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " (Quantity: " + quantity + ")";
    }
}
