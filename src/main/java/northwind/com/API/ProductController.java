package northwind.com.API;


import northwind.com.Business.Concretes.ProductManager;
import northwind.com.Core.DataResult;
import northwind.com.Core.Result;
import northwind.com.Entities.Concrete.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductManager productManager;

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAllProducts() {
        return productManager.getAll();
    }

    @GetMapping("/findById")
    public DataResult<Product> findProductId(int id) {
        return productManager.getById(id);
    }
    @PostMapping("/createNewRow")
    public Result createNewRow (@RequestBody Product product)
    {
        return productManager.createNewRow(product);
    }
    @DeleteMapping("/deleteRow")
    public Result deleteRow (int id)
    {
       return productManager.deleteRow(id);
    }
    @PostMapping("/updateRow")
    public Result updateRow (Product product)
    {
        return productManager.updateRow(product);
    }
}