package northwind.com.API;

import northwind.com.Business.Concretes.CategoryManager;
import northwind.com.Business.Request.CreateCategoryRequest;
import northwind.com.Business.Request.DeleteCategoryRequest;
import northwind.com.Business.Request.UpdateCategoryRequest;
import northwind.com.Business.Response.GetAllCategoryResponse;
import northwind.com.Business.Response.GetByIdCategoryResponse;
import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
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
    public DataResult<List<GetAllCategoryResponse>> getAll() {
        return categoryManager.getAllCategories();
    }

    @GetMapping("/getById")
    public DataResult<GetByIdCategoryResponse> getById(Integer categoryId) {
        return categoryManager.getById(categoryId);
    }
    @PostMapping("/createNewRow")
    public String createNewRow(@RequestBody CreateCategoryRequest category)
    {
        categoryManager.createNewRow(category);
        return "New row has been created succesfully";
    }
    @DeleteMapping("/deleteExistingRow")
    public Result deleteExistingRow(@RequestBody DeleteCategoryRequest request) throws UnknownHostException {
         return categoryManager.deleteExistingRow(request);
    }
    @PostMapping("/updateRow")
    public void updateRow(@RequestBody UpdateCategoryRequest category)
    {
        categoryManager.updateRow(category);
    }
}
