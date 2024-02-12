package northwind.com.Business.Abstracts;

import northwind.com.Entities.Concrete.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    Category createNewRow(Category category);
     void updateRow(Category category);
    String deleteExistingRow(Integer id);
    Category getById(int id);

    List<Category> getAllCategories();

}
