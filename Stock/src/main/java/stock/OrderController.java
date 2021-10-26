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
    CollectionModel<EntityModel<Order>> all(){
        return service.findAll();
    }

    @GetMapping("/orders/{id}")
    EntityModel<Order> one(@PathVariable Long id)throws Exception{
        return service.findById(id);
    }

    @PostMapping("/orders")
    ResponseEntity<?> newProduct (@RequestBody Order newOrder) throws URISyntaxException{
        EntityModel<Order> order = service.saveOrder(newOrder);
        return ResponseEntity.created(order.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(order);
    }
}
