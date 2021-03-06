package stock;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
class ProductOrder {

    private @Id @GeneratedValue long Id;
    private int productId;
    private int amount;
    private Date date;


    ProductOrder(){
        this.date = new Date();
    }
}
