package stock;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

class OrderResourceAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {

    @Override
    public EntityModel<Order> toModel(Order product) {
        return new EntityModel<Order>(
                product,
                linkTo(methodOn(OrderService.class).findById(product.getId())).withSelfRel(),
                linkTo(methodOn(OrderService.class).findAll()).withRel("/orders")
        );
    }
}
