package northwind.com.Business.Concretes;

import northwind.com.DataAccess.CategoryRepository;
import northwind.com.Entities.Concrete.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
@Service
public class CategoryManager {

    @Autowired
    private CategoryRepository categoryRepository;

     public List<Category> getAllCategories()
    {
       return categoryRepository.findAll();
    }

    public Category getById(int id)
    {
      return  categoryRepository.findById(id).get();
    }

    public Category createNewRow(Category category)
    {
        return categoryRepository.save(category);
    }
    public String deleteExistingRow(Integer id)
    {
         categoryRepository.deleteById(id);
        return "Element has been deleted successfully";
    }
    public void updateRow(Category category)
    {
        Category tempCategory= getById(category.getCategoryId());
        tempCategory.setCategoryName(category.getCategoryName());
        tempCategory.setDescription(category.getDescription());
        createNewRow(tempCategory);

    }




}
