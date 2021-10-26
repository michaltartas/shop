package catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Autowired
    CatalogRepository repository;
    @Bean
    public ProductResourceAssembler assembler(){
        return new ProductResourceAssembler();
    }

    @Bean
    public ProductService service(){
        return new ProductService(repository,assembler());
    }
}
