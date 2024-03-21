package northwind.com.Business.Concretes;

import northwind.com.Business.Abstracts.OrdersService;
import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
import northwind.com.Core.Result.SuccessDataResult;
import northwind.com.Core.Result.SuccessResult;
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
    public DataResult<List<Orders>> getAll()
    {
        List<Orders> all = ordersRepository.findAll();
        return new SuccessDataResult<>(true, "all rows has been listed successfully",all);
    }
    @Override
    public DataResult<Orders> getById(int id)
    {
        final Orders order = ordersRepository.findById(id).get();
        return new SuccessDataResult<>(true,"row has been fetched by id : ",order );
    }
    @Override
    public Result createNewRow (Orders order)
    {
        ordersRepository.save(order);
        return new SuccessDataResult<>(true, "has been created successfully",order);

    }
    @Override
    public Result deleteRow (int id)
    {
        ordersRepository.deleteById(id);
        return new SuccessResult(true,"Row has been deleted succesfully");
    }

    @Override
    public Result update(Orders order) {
        Orders tempOrder= getById(order.getOrderId()).getData();
        tempOrder.setCustomerId(order.getCustomerId());
        tempOrder.setOrderDate(order.getOrderDate());
        tempOrder.setEmployeeId(order.getEmployeeId());
        tempOrder.setShipperId(order.getShipperId());
        return  new SuccessDataResult<>(true,"has been updated succesfuly",tempOrder);
    }

}
