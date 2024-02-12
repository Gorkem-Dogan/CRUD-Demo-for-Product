package northwind.com.Entities.Concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customerid")
    int customerId;
    @Column(name="customername")
    String customerName;
    @Column(name="contactname")
    String contactname;
    @Column(name="address")
    String address;
    @Column(name="city")
    String city;
    @Column(name="postalcode")
    String postalCode;
    @Column(name="country")
    String country;

    @OneToMany(mappedBy = "customers")
    List<Orders> orders;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
