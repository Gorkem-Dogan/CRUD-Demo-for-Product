package northwind.com.Business.Concretes;

import northwind.com.Business.Abstracts.OrdersService;
import northwind.com.DataAccess.OrdersRepository;
import northwind.com.Entities.Concrete.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersManager implements OrdersService {
    @Autowired
    OrdersRepository ordersRepository;
    @Override
    public List<Orders> getAll()
    {
        return ordersRepository.findAll();
    }
    @Override
    public Orders getById(int id)
    {
        return ordersRepository.findById(id).get();
    }
    @Override
    public Orders createNewRow (Orders order)
    {
        return ordersRepository.save(order);

    }
    @Override
    public String deleteRow (int id)
    {
        ordersRepository.deleteById(id);
        return "Row has been deleted succesfully";
    }

    @Override
    public void update(Orders order) {
        Orders tempOrder= getById(order.getOrderId());
        tempOrder.setCustomerId(order.getCustomerId());
        tempOrder.setOrderDate(order.getOrderDate());
        tempOrder.setEmployeeId(order.getEmployeeId());
        tempOrder.setShipperId(order.getShipperId());
    }

}
