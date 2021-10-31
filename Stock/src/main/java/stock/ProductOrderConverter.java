package stock;

public class ProductOrderConverter {

    public ProductOrderConverter() {
    }

    public ProductOrderDto from(ProductOrder order, ProductResponse product){
        return new ProductOrderDto(order.getId(),order.getProductId(), order.getAmount(), order.getDate(), product.getName());
    }
}
