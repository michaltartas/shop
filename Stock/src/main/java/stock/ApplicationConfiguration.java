package stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Autowired
    OrderRepository repository;

    @Bean
    OrderResourceAssembler assembler(){
        return new OrderResourceAssembler();
    }
    @Bean
    OrderService service(){
        return new OrderService(repository, assembler());
    }
}