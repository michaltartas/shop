package stock;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

//class ProductOrderDtoResourceAssembler implements RepresentationModelAssembler<ProductOrderDto, EntityModel<ProductOrderDto>> {
//
//    @Override
//    public EntityModel<ProductOrder> toModel(ProductOrder order) {
//        return new EntityModel<ProductOrder>(
//                order,
//                linkTo(methodOn(OrderService.class).findById(order.getId())).withSelfRel(),
//                linkTo(methodOn(OrderService.class).findAll()).withRel("/orders")
//        );
//    }
//}
