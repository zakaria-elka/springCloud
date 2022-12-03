package com.SpringCloud.Spring_Cloud_inventory;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;



@SpringBootApplication
public class SpringCloudInventoryApplication  {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudInventoryApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        restConfiguration.exposeIdsFor(Product.class);
        return args -> {
            productRepository.save(new Product(null,"Ordinateur",788,99));
            productRepository.save(new Product(null,"Telephone",700,40));
            productRepository.save(new Product(null,"Imprimante",300,20));
            productRepository.findAll().forEach(p->{
                System.out.println(p.getName());
            });
        };
    }
}

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private double quantity;
}

@RepositoryRestResource
interface ProductRepository extends JpaRepository<Product,Long>{

}
