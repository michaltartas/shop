package catalog;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class ProductService {

    private final CatalogRepository repository;
    private final ProductResourceAssembler assembler;

    ProductService(CatalogRepository repository, ProductResourceAssembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }

    EntityModel <Product> one(long id) {
        Product product = repository.findById(id)
                .orElseThrow( () -> new ProductNotFoundException(id));

        return assembler.toModel(product);
    }

    CollectionModel<EntityModel<Product>> all() {
        List<EntityModel<Product>> products = repository.findAll().stream()
                .map(assembler::toModel).collect(Collectors.toList());

        return new CollectionModel<>(products,
                linkTo(methodOn(ProductService.class).all()).withSelfRel() );
    }

    EntityModel<Product> saveProduct(Product newProduct){
        EntityModel <Product> productEntity = assembler.toModel( repository.save(newProduct));
        return productEntity;
    }
}
