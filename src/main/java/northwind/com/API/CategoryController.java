package northwind.com.API;

import northwind.com.Business.Concretes.CategoryManager;
import northwind.com.Entities.Concrete.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    CategoryManager categoryManager;

    @GetMapping("/getAll")
    public List<Category> getAll() {
        return categoryManager.getAllCategories();
    }

    @GetMapping("/getById")
    public Category getById(int id) {
        return categoryManager.getById(id);
    }
    @PostMapping("/createNewRow")
    public String createNewRow(Category category)
    {
        categoryManager.createNewRow(category);
        return "New row has been created succesfully";
    }
    @GetMapping("/deleteExistingRow")
    public String deleteExistingRow(Integer id)
    {
         return categoryManager.deleteExistingRow(id);
    }
    @PostMapping("/updateRow")
    public void updateRow(Category category)
    {
        categoryManager.updateRow(category);
    }
}
