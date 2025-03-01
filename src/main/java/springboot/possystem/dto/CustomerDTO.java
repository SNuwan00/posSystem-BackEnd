package springboot.possystem.dto;

import lombok.*;

@NoArgsConstructor
@Getter@Setter
public class CustomerDTO {
    private int customerID;
    private String CustomerName;
    private String CustomerAddress;
    private double CustomerSalary;
    private String contactNumber;
    private String nic;
    private boolean active;

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

    public String getContactNumber() {
        return contactNumber;
    }

    public String getNic() {
        return nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public void setCustomerSalary(double customerSalary) {
        CustomerSalary = customerSalary;
    }

    public void setContactNumber(String contactNumbers) {
        this.contactNumber = contactNumbers;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CustomerDTO(int customerID, String customerName, String customerAddress, double customerSalary, String contactNumber, String nic, boolean active) {
        this.customerID = customerID;
        CustomerName = customerName;
        CustomerSalary = customerSalary;
        CustomerAddress = customerAddress;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.active = active;
    }
}
