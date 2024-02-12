package northwind.com.Business.Abstracts;

import northwind.com.Entities.Concrete.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(Integer id);
    Product createNewRow(Product product);
    void deleteRow(int id);
    void updateRow(Product product);
}
