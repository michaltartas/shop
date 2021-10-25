package shop;

class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(long id) {
        super("Cound not find product with id :" + id);
    }
}
