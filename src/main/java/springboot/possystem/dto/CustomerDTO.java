package springboot.possystem.dto;

import lombok.*;

@Getter
@Setter
public class CustomerDTO {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private double customerSalary;
    private String contactNumber;
    private String nic;
    private boolean active;

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public boolean isActive() {
        return active;
    }

    public CustomerDTO() {
    }

    public CustomerDTO(int customerID, String customerName, String customerAddress, double customerSalary, String contactNumber, String nic, boolean active) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.active = active;
    }
}
