package emsi.ma.model_mapper.mappers;

import emsi.ma.model_mapper.dtos.CustomerDTO;
import emsi.ma.model_mapper.dtos.CustomerDtoNew;
import emsi.ma.model_mapper.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper{

    private ModelMapper mapper=new ModelMapper();
    // customer to DTO
    public CustomerDTO fromCustomerToDTO(Customer customer){
        return this.mapper.map(customer, CustomerDTO.class);
    }

    //DTO to customer
    public Customer fromDTOToCustomer(CustomerDTO dto){
        return this.mapper.map(dto, Customer.class);
    }


    //dtoNew

    // customer to DTO
    public CustomerDtoNew fromCustomerToDTONew(Customer customer){
        return this.mapper.map(customer, CustomerDtoNew.class);
    }

    //DTO to customer
    public Customer fromDTONewToCustomer(CustomerDtoNew dto){
        return this.mapper.map(dto, Customer.class);
    }
}
