package northwind.com.Business.Concretes;

import northwind.com.Business.Abstracts.OrdersService;
import northwind.com.Business.Request.Orders.CreateOrdersResult;
import northwind.com.Business.Request.Orders.DeleteOrdersRequest;
import northwind.com.Business.Request.Orders.UpdateOrdersRequest;
import northwind.com.Business.Response.Orders.GetAllOrdersResponse;
import northwind.com.Business.Response.Orders.GetByIdOrdersResponse;
import northwind.com.Core.Mapping.ModelMapperService;
import northwind.com.Core.Mapping.ModelMapperServiceImpl;
import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
import northwind.com.Core.Result.SuccessDataResult;
import northwind.com.Core.Result.SuccessResult;
import northwind.com.DataAccess.OrdersRepository;
import northwind.com.Entities.Concrete.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersManager implements OrdersService {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    ModelMapperService modelMapperService;
    @Override
    public DataResult<List<GetAllOrdersResponse>> getAll()
    {
        List<Orders> all = ordersRepository.findAll();
        List<GetAllOrdersResponse> collect = all.stream().map(orders -> this.modelMapperService.forResponce().map(orders, GetAllOrdersResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(true, "all rows has been listed successfully",collect);
    }
    @Override
    public DataResult<GetByIdOrdersResponse> getById(Integer id)
    {
        Orders order = ordersRepository.findById(id).get();
         GetByIdOrdersResponse ordersResponse = this.modelMapperService.forResponce().map(order, GetByIdOrdersResponse.class);
        return new SuccessDataResult<GetByIdOrdersResponse>(true,"row has been fetched by id : ",ordersResponse );
    }
    @Override
    public Result createNewRow (CreateOrdersResult createOrdersResult)
    {
        Orders tempOrder = this.modelMapperService.forRequest().map(createOrdersResult, Orders.class);
        ordersRepository.save(tempOrder);
        return new SuccessDataResult<>(true, "has been created successfully",tempOrder);

    }
    @Override
    public Result deleteRow (DeleteOrdersRequest deleteOrdersRequest)
    {
        ordersRepository.deleteById(deleteOrdersRequest.getOrderId());
        return new SuccessResult(true,"Row has been deleted succesfully");
    }

    @Override
    public Result update(UpdateOrdersRequest updateOrdersRequest) {
         Orders tempOrder = this.modelMapperService.forRequest().map(updateOrdersRequest, Orders.class);
         ordersRepository.save(tempOrder);
         return  new SuccessDataResult<>(true,"has been updated succesfuly",tempOrder);
//        manual and not modelmapper used version
//        tempOrder.setCustomerId(order.getCustomerId());
//        tempOrder.setOrderDate(order.getOrderDate());
//        tempOrder.setEmployeeId(order.getEmployeeId());
//        tempOrder.setShipperId(order.getShipperId());
    }

}
