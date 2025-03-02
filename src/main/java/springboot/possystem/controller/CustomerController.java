package springboot.possystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.possystem.dto.CustomerDTO;
import springboot.possystem.dto.request.CustomerUpdateDTO;
import springboot.possystem.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.saveCustomer(customerDTO);
        return "saved";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
        customerService.updateCustomer(customerUpdateDTO);
        return "updated";
    }

    @GetMapping(path = "/get-by-id/{customerID}")
    public CustomerDTO getCustomerByID(@PathVariable int customerID) {
        return customerService.getCustomerByID(customerID);
    }

    @DeleteMapping("/delete/{customerID}")
    public String deleteById(@PathVariable int customerID){
        String deleted = customerService.deleteCustomer(customerID);
        return deleted;
    }

    @GetMapping("/get-all")
    public List<CustomerDTO> getAll(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @GetMapping(path = "/get-all-customers-by-active-state/{status}")
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable boolean status){
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(status);
        return allCustomers;
    }
}
/*
{
  "customerID": 1,
  "contactNumber": "0708474781",
  "nic": "200031702509",
  "active": true,
  "customerName": "Sanjuka Sri Nuwan",
  "customerSalary": 1000000,
  "customerAddress": "Kattakaduwa, Ranna"
}
*/