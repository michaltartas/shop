package stock;

import org.springframework.hateoas.EntityModel;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

public class OrderService {

    private final OrderRepository repository;
//    private final ProductOrderDtoResourceAssembler assembler;

    OrderService(OrderRepository repository){
        this.repository = repository;
//        this.assembler = assembler;

    }
    ProductOrder findById(long id) {
        ProductOrder productOrder = repository.findById(id)
                .orElseThrow( () -> new OrderNotFoundException(id));


        return productOrder;
    }

    List<ProductOrder> findAll() {
        return  repository.findAll() ;



    }

    void saveOrder(ProductOrder newProductOrder){
//        ProductOrder
        repository.save(newProductOrder);

    }
}
