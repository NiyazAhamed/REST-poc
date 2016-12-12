package com.store;

import com.store.dao.ProductRepository;
import com.store.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2

@ComponentScan({
        "com.store.controller",
        "com.store.service"
})

public class DemoApplication {
    
	public static void main(String[] args) {
		
        SpringApplication.run(DemoApplication.class, args);
        
	}

    @Bean
    public CommandLineRunner demo(ProductRepository repository) {
        return (args) -> {
            repository.save(new Product(5555, "AEX143", "Stroller", "baby", "2014-05-23", 199.99f));
            repository.save(new Product(5552, "AdX143", "Stdddller", "cat", "2014-06-23", 29.99f));

            for (Product product : repository.findAll()) {
                System.out.println(product);
            }
        };

        
    }
	

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("products")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.regex("/products.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sample with Swagger")
                .description("Spring REST Sample with Swagger")
                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
    
    
}
