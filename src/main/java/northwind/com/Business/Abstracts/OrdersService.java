package northwind.com.Business.Abstracts;

import northwind.com.Business.Request.Orders.CreateOrdersResult;
import northwind.com.Business.Request.Orders.DeleteOrdersRequest;
import northwind.com.Business.Request.Orders.UpdateOrdersRequest;
import northwind.com.Business.Response.Orders.GetAllOrdersResponse;
import northwind.com.Business.Response.Orders.GetByIdOrdersResponse;
import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
import northwind.com.Entities.Concrete.Orders;

import java.util.List;

public interface OrdersService {
     DataResult<List<GetAllOrdersResponse>> getAll();

    DataResult<GetByIdOrdersResponse> getById(Integer id);
    Result createNewRow(CreateOrdersResult order);
    Result deleteRow (DeleteOrdersRequest deleteOrdersRequest);
    Result update(UpdateOrdersRequest updateOrdersRequest);

}
