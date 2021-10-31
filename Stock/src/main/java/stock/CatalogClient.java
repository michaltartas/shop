package stock;

import org.springframework.web.client.RestTemplate;

public class CatalogClient {

    private final RestTemplate restTemplate;

    public CatalogClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public ProductResponse findById(long id){
        return restTemplate.getForObject("http://localhost:8081/products/{id}",ProductResponse.class,id);
    }


//    public static class ProductResponse{
//        private final long id;
//        private final String name;
//
//        ProductResponse(long id, String name){
//            this.id = id;
//            this.name = name;
//        }
//
//        long getId(){
//            return this.id;
//        }
//
//        String getName(){
//            return this.name;
//        }
//
//    }
}
