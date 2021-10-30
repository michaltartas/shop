package stock;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

class OrderResourceAssembler implements RepresentationModelAssembler<ProductOrder, EntityModel<ProductOrder>> {

    @Override
    public EntityModel<ProductOrder> toModel(ProductOrder product) {
        return new EntityModel<ProductOrder>(
                product,
                linkTo(methodOn(OrderService.class).findById(product.getId())).withSelfRel(),
                linkTo(methodOn(OrderService.class).findAll()).withRel("/orders")
        );
    }
}
