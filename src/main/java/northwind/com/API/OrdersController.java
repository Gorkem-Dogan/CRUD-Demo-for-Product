package northwind.com.API;

import northwind.com.Business.Concretes.OrdersManager;
import northwind.com.Business.Request.Orders.CreateOrdersResult;
import northwind.com.Business.Request.Orders.DeleteOrdersRequest;
import northwind.com.Business.Response.Orders.GetAllOrdersResponse;
import northwind.com.Business.Response.Orders.GetByIdOrdersResponse;
import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
import northwind.com.Entities.Concrete.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class OrdersController {
    @Autowired
    OrdersManager ordersManager;

    @GetMapping("/getAll")
    public DataResult<List<GetAllOrdersResponse>> getAll() {
        return ordersManager.getAll();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdOrdersResponse> getById(@RequestParam Integer id) {
        return ordersManager.getById(id);
    }

    @PostMapping("/createNewRow")
    public Result createNewRow(@RequestBody CreateOrdersResult order) {

        return ordersManager.createNewRow(order);

    }
    @DeleteMapping("/deleteRow")
    public Result deleteRow(@RequestBody DeleteOrdersRequest deleteOrdersRequest) {
       return ordersManager.deleteRow(deleteOrdersRequest);

    }
}