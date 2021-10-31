package stock;


public class ProductResponse{

    private final long Id;
    private String name;
    private Float price;
    private String description;

    public ProductResponse(long id, String name, Float price, String description) {
        Id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }


    long getId(){
        return this.Id;
    }

    String getName(){
        return this.name;
    }

}