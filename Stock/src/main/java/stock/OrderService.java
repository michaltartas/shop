package stock;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class OrderService {

    private final OrderRepository repository;
    private final OrderResourceAssembler assembler;

    OrderService(OrderRepository repository, OrderResourceAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;

    }
    EntityModel<ProductOrder> findById(long id) {
        ProductOrder productOrder = repository.findById(id)
                .orElseThrow( () -> new OrderNotFoundException(id));

        return assembler.toModel(productOrder);
    }

    CollectionModel<EntityModel<ProductOrder>> findAll() {
        List<EntityModel<ProductOrder>> orders = repository.findAll().stream()
                .map(assembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(orders,
                linkTo(methodOn(OrderService.class).findAll()).withSelfRel() );
    }

    EntityModel<ProductOrder> saveOrder(ProductOrder newProductOrder){
        EntityModel <ProductOrder> productEntity = assembler.toModel( repository.save(newProductOrder));
        return productEntity;
    }
}
