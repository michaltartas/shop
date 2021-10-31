package stock;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Data;

import java.util.Date;

@Data
public class ProductOrderDto {

    private final long Id;
    private final int productId;
    private final int amount;
    private final Date date;
    private final String name;

    @JsonCreator
    ProductOrderDto(long id, int productId, int amount, Date date, String name){
        Id = id;
        this.productId = productId;
        this.amount = amount;
        this.date = date;
        this.name = name;
    }


}
