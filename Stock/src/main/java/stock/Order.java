package stock;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
class Order {

    private @Id
    @GeneratedValue long Id;

    private int productId;
    private String orderDate ;
    private boolean active ;

    Order(){}

}
