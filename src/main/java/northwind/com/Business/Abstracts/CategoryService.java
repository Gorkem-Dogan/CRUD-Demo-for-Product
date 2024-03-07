package northwind.com.Business.Abstracts;

import northwind.com.Core.DataResult;
import northwind.com.Core.Result;
import northwind.com.Entities.Concrete.Category;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.List;

@Service
public interface CategoryService {
    Result createNewRow(Category category);
    Result updateRow(Category category);
    Result deleteExistingRow(Integer id) throws UnknownHostException;
    DataResult<Category> getById(int id);

    DataResult<List<Category>> getAllCategories();

}
