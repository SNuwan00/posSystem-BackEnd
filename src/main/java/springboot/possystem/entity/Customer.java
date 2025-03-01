package springboot.possystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customers")
@Access(AccessType.FIELD)
@Getter@Setter
public class Customer {
    @Id
    @Column(name = "customer_id", length = 15)
    private int customerID;

    @Column(name = "customer_name", length = 100, nullable = false)
    private String CustomerName;

    @Column(name = "customer_address", length = 250)
    private String CustomerAddress;

    @Column(name = "customer_salary")
    private double CustomerSalary;

    @Column(name= "contact_number")
    private String contactNumber;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0")
    private boolean activeState;

    public Customer() {
    }

    public Customer(int customerID, String customerName, String customerAddress, double customerSalary, String contactNumber, String nic, boolean activeState) {
        this.customerID = customerID;
        CustomerName = customerName;
        CustomerAddress = customerAddress;
        CustomerSalary = customerSalary;
        this.contactNumber = contactNumber;
        this.nic = nic;
        this.activeState = activeState;
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

    public boolean isActiveState() {
        return activeState;
    }

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

    public String getNic() {
        return nic;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
