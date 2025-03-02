package springboot.possystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.possystem.dto.CustomerDTO;
import springboot.possystem.dto.request.CustomerUpdateDTO;
import springboot.possystem.entity.Customer;
import springboot.possystem.repo.CustomerRepo;
import springboot.possystem.service.CustomerService;

import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerID(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
    }

    @Override
    public void updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        Customer customer = customerRepo.findById(customerUpdateDTO.getCustomerID()).get();
        customer.setCustomerName(customerUpdateDTO.getCustomerName());
        customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
        customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());
        customerRepo.save(customer);
    }

    @Override
    public CustomerDTO getCustomerByID(int customerID) {
        Customer customer = customerRepo.findById(customerID).get();
        CustomerDTO customerDTO = new CustomerDTO(
                customer.getCustomerID(),
                customer.getCustomerName(),
                customer.getCustomerAddress(),
                customer.getCustomerSalary(),
                customer.getContactNumber(),
                customer.getNic(),
                customer.isActiveState()
        );
        return customerDTO;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepo.findAll()
                .stream()
                .map(customer -> new CustomerDTO(customer.getCustomerID(), customer.getCustomerName(), customer.getCustomerAddress(),customer.getCustomerSalary(),customer.getContactNumber(),customer.getNic(),customer.isActiveState()))
                .toList();
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean status) {
        return customerRepo.getAllCustomersByActiveState(status)
                .stream()
                .map(customer -> new CustomerDTO(customer.getCustomerID(), customer.getCustomerName(), customer.getCustomerAddress(),customer.getCustomerSalary(),customer.getContactNumber(),customer.getNic(),customer.isActiveState()))
                .toList();
    }

    @Override
    public String deleteCustomer(int customerID) {
        customerRepo.deleteById(customerID);
        return "Deleted";
    }
}
