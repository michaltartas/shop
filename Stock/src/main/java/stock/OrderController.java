package stock;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
public class OrderController {

    private final OrderService service;

    OrderController(OrderService service){
        this.service = service;
    }

    @GetMapping("/orders")
    CollectionModel<EntityModel<ProductOrder>> all(){
        return service.findAll();
    }

    @GetMapping("/orders/{id}")
    EntityModel<ProductOrder> one(@PathVariable Long id)throws Exception{
        return service.findById(id);
    }

    @PostMapping("/orders")
    ResponseEntity<?> newOrder (@RequestBody ProductOrder newProductOrder) throws URISyntaxException{
        EntityModel<ProductOrder> order = service.saveOrder(newProductOrder);
        return ResponseEntity.created(order.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(order);
    }
}
