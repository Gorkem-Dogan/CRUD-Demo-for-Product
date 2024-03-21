package northwind.com.API;

import northwind.com.Business.Concretes.SuppliersManager;
import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
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
    public DataResult<List<Suppliers>> getAll(Suppliers supplier)
    {
        return suppliersManager.getAll(supplier);
    }
    @PostMapping("/createNewRow")
    public Result createNewRow(Suppliers supplier)
    {

        return suppliersManager.createRow(supplier);
    }
    @DeleteMapping("/deleteRow")
    public Result deleteRow(int id)
    {
        return  suppliersManager.deleteRow(id);

    }
    @PostMapping("/updateRow")
    public Result updateRow(Suppliers supplier)
    {
        return suppliersManager.updateRow(supplier);
    }



}
