package stock;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class ProductOrder {

    private @Id @GeneratedValue long Id;
//    private int productId;
//    private Float price;
//    private String description;

    ProductOrder(){}
}
