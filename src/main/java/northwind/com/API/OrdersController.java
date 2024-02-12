package northwind.com.API;

import northwind.com.Business.Concretes.OrdersManager;
import northwind.com.Entities.Concrete.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/orders")
public class OrdersController {
    @Autowired
    OrdersManager ordersManager;
@GetMapping("/getAll")
    public List<Orders> getAll()
{
     return ordersManager.getAll();
}
@GetMapping("/getById")
    public Orders getById(@RequestParam Integer id )
{
     return ordersManager.getById(id);
}
@PostMapping("/createNewRow")
        public String createNewRow(Orders order)
{
     ordersManager.createNewRow(order);
    return "New row has been added succesfully";

}
@DeleteMapping("/deleteRow")
    public void deleteRow(Integer id)
{
    ordersManager.deleteRow(id);
}

}
