package stock;

class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(long id) {
        super("Cound not find order");
    }
}
