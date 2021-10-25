package shop;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Product {

    private @Id
    @GeneratedValue long Id;
    private String name;
    private Float price;
    private String description;

    Product(){}
}
