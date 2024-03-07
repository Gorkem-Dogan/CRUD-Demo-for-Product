package northwind.com.API;

import northwind.com.Business.Concretes.CategoryManager;
import northwind.com.Core.DataResult;
import northwind.com.Core.Result;
import northwind.com.Entities.Concrete.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    CategoryManager categoryManager;

    @GetMapping("/getAll")
    public DataResult<List<Category>> getAll() {
        return categoryManager.getAllCategories();
    }

    @GetMapping("/getById")
    public DataResult<Category> getById(int id) {
        return categoryManager.getById(id);
    }
    @PostMapping("/createNewRow")
    public String createNewRow(Category category)
    {
        categoryManager.createNewRow(category);
        return "New row has been created succesfully";
    }
    @DeleteMapping("/deleteExistingRow")
    public Result deleteExistingRow(Integer id) throws UnknownHostException {
         return categoryManager.deleteExistingRow(id);
    }
    @PostMapping("/updateRow")
    public void updateRow(Category category)
    {
        categoryManager.updateRow(category);
    }
}
