package northwind.com.Business.Abstracts;

import northwind.com.Entities.Concrete.Orders;
import org.hibernate.query.Order;

import java.util.List;

public interface OrdersService {
     List<Orders> getAll();

    Orders getById(int id);
    Orders createNewRow(Orders order);
    String deleteRow (int id);
    void update(Orders order);

}
