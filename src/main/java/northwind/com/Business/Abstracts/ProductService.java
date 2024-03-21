package northwind.com.Business.Abstracts;

import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
import northwind.com.Entities.Concrete.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<Product> getById(Integer id);
    Result createNewRow(Product product);
    Result deleteRow(int id);
    Result updateRow(Product product);
}
