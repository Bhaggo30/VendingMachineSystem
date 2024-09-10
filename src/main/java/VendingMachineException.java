class VendingMachineException extends Exception {
    public VendingMachineException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends VendingMachineException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class ProductNotFoundException extends VendingMachineException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class OutOfStockException extends VendingMachineException {
    public OutOfStockException(String message) {
        super(message);
    }
}
