package northwind.com.API;


import northwind.com.Business.Concretes.ProductManager;
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
    public List<Product> getAllProducts() {
        return productManager.getAll();
    }

    @GetMapping("/findById")
    public Product findProductId(int id) {
        return productManager.getById(id);
    }
    @PostMapping("/createNewRow")
    public Product createNewRow (@RequestBody Product product)
    {
        return productManager.createNewRow(product);
    }
    @GetMapping("/deleteRow")
    public void deleteRow (int id)
    {
        productManager.deleteRow(id);
    }
    @PostMapping("/updateRow")
    public void updateRow (Product product)
    {
        productManager.updateRow(product);
    }




}