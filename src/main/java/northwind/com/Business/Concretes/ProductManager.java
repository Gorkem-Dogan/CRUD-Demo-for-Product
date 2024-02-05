package northwind.com.Business.Concretes;


import northwind.com.DataAccess.ProductRepository;
import northwind.com.Entities.Concrete.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager {
    @Autowired
    ProductRepository productRepository;
    public List<Product> getAll()
    {
        return productRepository.findAll();

    }
    public Product getById(int id)
    {
        return productRepository.findById(id).get();
    }
    public Product createNewRow(Product product)
    {
         return productRepository.save(product);

    }
    public void deleteRow(int id)
    {

        productRepository.deleteById(id);
    }
    public void updateRow(Product product)
    {
        Product tempProduct = getById(product.getProductId());
        tempProduct.setProductName(product.getProductName());
        tempProduct.setPrice(product.getPrice());
        tempProduct.setUnit(product.getUnit());
        tempProduct.setSupplierId(product.getSupplierId());
        tempProduct.setCategoryId(product.getCategoryId());
        createNewRow(tempProduct);

    }


}
