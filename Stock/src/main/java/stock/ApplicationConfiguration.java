package stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class ApplicationConfiguration {


    @Autowired
    OrderRepository repository;

    @Bean
    public RestTemplate restTemplate(List<HttpMessageConverter<?>> messageConverters){
        return new RestTemplate(messageConverters);
    }

    @Bean
    public ProductOrderConverter converter(){
        return new ProductOrderConverter();
    }

    @Bean
    public CatalogClient catalogClient(RestTemplate restTemplate){
        return new CatalogClient(restTemplate );
    }

//    @Bean
//    public ProductOrderDtoResourceAssembler assembler(){
//        return new ProductOrderDtoResourceAssembler();
//    }

    @Bean
    public OrderService service(OrderRepository repository){
        return new OrderService(repository);
    }
}
