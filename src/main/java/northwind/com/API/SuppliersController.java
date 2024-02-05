package northwind.com.API;

import northwind.com.Business.Concretes.SuppliersManager;
import northwind.com.Entities.Concrete.Suppliers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SuppliersController {
    @Autowired
    private SuppliersManager suppliersManager;
    @GetMapping("/getAll")
    public List<Suppliers> getAll(Suppliers supplier)
    {
        return suppliersManager.getAll(supplier);
    }
    @PostMapping("/createNewRow")
    public void createNewRow(Suppliers supplier)
    {
        suppliersManager.createRow(supplier);
    }
    @DeleteMapping("/deleteRow")
            public void deleteRow(int id)
    {
         suppliersManager.deleteRow(id);
    }
    @PostMapping("/updateRow")
    public void updateRow(Suppliers supplier)
    {
        suppliersManager.updateRow(supplier);
    }



}
