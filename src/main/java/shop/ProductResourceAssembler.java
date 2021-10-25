package shop;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
@Component
class ProductResourceAssembler implements RepresentationModelAssembler<Product, EntityModel<Product>> {

    @Override
    public EntityModel<Product> toModel(Product product) {
        return new EntityModel<Product>(
                product,
                linkTo(methodOn(ProductService.class).one(product.getId())).withSelfRel(),
                linkTo(methodOn(ProductService.class).all()).withRel("/products")
        );
    }
}
