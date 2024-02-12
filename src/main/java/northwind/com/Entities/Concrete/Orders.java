package northwind.com.Entities.Concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    int orderId;
    @Column(name="customerid")
    int customerId;
    @Column(name="employeeid")
    int employeeId;
    @Column(name = "orderdate")
    Timestamp orderDate;
    @Column(name="shipperid")
    int shipperId;
    @ManyToOne
    @JoinColumn(insertable = false,updatable = false,name = "employeeid")
    private Employees employees;
    @ManyToOne
    @JoinColumn(insertable = false,updatable = false,name = "customerid")
    private Customers customers;
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getShipperId() {
        return shipperId;
    }

    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }
}
