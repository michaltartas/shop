package stock;

import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {

    private final OrderService service;
    private final ProductOrderConverter converter;
    private final CatalogClient catalog;

    OrderController(OrderService service,ProductOrderConverter converter, CatalogClient catalog){
        this.service = service;
        this.converter = converter;
        this.catalog = catalog;
    }

    @GetMapping("/orders")
    List<ProductOrderDto> all(){
        List<ProductOrder> orders =  service.findAll();
        return  orders.stream().map(o -> converter.from(o, catalog.findById(o.getProductId()))).collect(Collectors.toList());
    }

    @GetMapping("/orders/{id}")
    ProductOrderDto one(@PathVariable Long id)throws Exception{
        ProductOrder order = service.findById(id);
        return converter.from(order, catalog.findById(order.getProductId()));
    }

    @PostMapping("/orders")
    void newOrder (@RequestBody ProductOrder newProductOrder) throws URISyntaxException{
        service.saveOrder(newProductOrder);

    }
}
