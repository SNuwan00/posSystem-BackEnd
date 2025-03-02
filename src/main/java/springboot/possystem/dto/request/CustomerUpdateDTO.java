package springboot.possystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerUpdateDTO {
    private int customerID;
    private String CustomerName;
    private String CustomerAddress;
    private double CustomerSalary;

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public double getCustomerSalary() {
        return CustomerSalary;
    }
}
