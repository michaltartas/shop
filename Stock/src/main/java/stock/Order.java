package stock;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Order {

    private @Id @GeneratedValue long Id;
//    private int productId;
//    private Float price;
//    private String description;

    Order(){}
}
