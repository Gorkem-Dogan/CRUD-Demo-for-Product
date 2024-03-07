package northwind.com.Business.Concretes;


import northwind.com.Business.Abstracts.ProductService;
import northwind.com.Core.DataResult;
import northwind.com.Core.Result;
import northwind.com.Core.SuccessDataResult;
import northwind.com.Core.SuccessResult;
import northwind.com.DataAccess.ProductRepository;
import northwind.com.Entities.Concrete.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public DataResult<List<Product>> getAll()
    {
         List<Product> all=  productRepository.findAll();
         return new SuccessDataResult<>(true, "all products has been listed succesfully",all);

    }
    @Override
    public DataResult<Product> getById(Integer id)
    {
        Product product=  productRepository.findById(id).get();
         return new SuccessDataResult<>(true,"has been returned to you succesfully: ",product);
    }
    @Override
    public Result createNewRow(Product product)
    {
          productRepository.save(product);
          return new SuccessDataResult<>(true, "the added product is shown :",product);

    }
    @Override
    public Result deleteRow(int id)
    {
        productRepository.deleteById(id);
        return new SuccessResult(true,"has been deleted successfully");
    }
    @Override
    public Result updateRow(Product product)
    {
        Product tempProduct = getById(product.getProductId()).getData();
        tempProduct.setProductName(product.getProductName());
        tempProduct.setPrice(product.getPrice());
        tempProduct.setUnit(product.getUnit());
        tempProduct.setSupplierId(product.getSupplierId());
        tempProduct.setCategoryId(product.getCategoryId());
        createNewRow(tempProduct);
        return new SuccessDataResult<>(true,"has been updated successfully",tempProduct);

    }


}
