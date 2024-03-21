package northwind.com.API;

import northwind.com.Business.Concretes.OrdersManager;
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
    public DataResult<List<Orders>> getAll() {
        return ordersManager.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Orders> getById(@RequestParam Integer id) {
        return ordersManager.getById(id);
    }

    @PostMapping("/createNewRow")
    public Result createNewRow(Orders order) {

        return ordersManager.createNewRow(order);

    }

    @DeleteMapping("/deleteRow")
    public Result deleteRow(Integer id) {
       return ordersManager.deleteRow(id);

    }
}