package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    Long id;
    String customerFirstName;
    String customerLastName;
    String customerBirthDate;
    String customerGender;
    String customerPesel;

    public Customer() {
        super();
    }

public Customer(Long id, String customerFirstName, String customerLastName, String customerBirthDate, String customerGender, String customerPesel) {
        super();
        this.id = id;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.customerBirthDate = customerBirthDate;
        this.customerGender = customerGender;
        this.customerPesel = customerPesel;
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerBirthDate() {
        return customerBirthDate;
    }

    public void setCustomerBirthDate(String customerBirthDate) {
        this.customerBirthDate = customerBirthDate;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerPesel() {
        return customerPesel;
    }

    public void setCustomerPesel(String customerPesel) {
        this.customerPesel = customerPesel;
    }

}
