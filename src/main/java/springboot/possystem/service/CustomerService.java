package springboot.possystem.service;

import org.springframework.stereotype.Service;
import springboot.possystem.dto.CustomerDTO;
import springboot.possystem.dto.request.CustomerUpdateDTO;

import java.util.List;

@Service
public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO getCustomerByID(int customerID);

    List<CustomerDTO> getAllCustomers();

    List<CustomerDTO> getAllCustomersByActiveState(boolean status);

    String deleteCustomer(int customerID);
}
