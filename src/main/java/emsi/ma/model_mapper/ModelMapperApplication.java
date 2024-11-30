package emsi.ma.model_mapper;

import emsi.ma.model_mapper.dtos.CustomerDTO;
import emsi.ma.model_mapper.entities.Customer;
import emsi.ma.model_mapper.entities.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import emsi.ma.model_mapper.mappers.CustomerMapper;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ModelMapperApplication {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(ModelMapperApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            Customer c1= Customer.builder().name("x").email("x@gmail.com").password("123")
                    .build();

            Customer c2= Customer.builder().name("y").email("y@gmail.com").password("123")
                    .build();

            Customer c3= Customer.builder().name("z").email("z@gmail.com").password("123")
                    .build();

            // Ajout des customers à une liste
            List<Customer> customers = new ArrayList<>();
            customers.add(c1);
            customers.add(c2);
            customers.add(c3);

            // Sauvegarde dans la base de données
            customerRepository.saveAll(customers);

            // 14. Transformation des customers en CustomerDTO
            List<CustomerDTO> customerDtosList = customers.stream()
                    .map(customerMapper::fromCustomerToDTO) // Utilisation de la méthode du mapper
                    .collect(Collectors.toList());

            // Affichage des CustomerDTO
            customerDtosList.forEach(customerDTO -> System.out.println("CustomerDTO: " + customerDTO));





        };



    }

}
