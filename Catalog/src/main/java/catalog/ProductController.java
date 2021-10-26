package catalog;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
public class ProductController {

    private final ProductService service;

    ProductController(ProductService service){
        this.service = service;
    }

    @GetMapping("/products")
    CollectionModel<EntityModel<Product>> all(){
        return service.all();
    }

    @GetMapping("/products/{id}")
    EntityModel<Product> one(@PathVariable Long id)throws Exception{
        return service.one(id);
    }

    @PostMapping("/products")
    ResponseEntity<?> newProduct (@RequestBody Product newProduct) throws URISyntaxException{
        EntityModel<Product> product = service.saveProduct(newProduct);
        return ResponseEntity.created(product.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(product);
    }
}
