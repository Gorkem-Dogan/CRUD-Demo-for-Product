package northwind.com.Business.Concretes;

import northwind.com.Business.Abstracts.CategoryService;
import northwind.com.Core.DataResult;
import northwind.com.Core.Result;
import northwind.com.Core.SuccessDataResult;
import northwind.com.Core.SuccessResult;
import northwind.com.DataAccess.CategoryRepository;
import northwind.com.Entities.Concrete.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
@Service
public class CategoryManager implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
     public DataResult<List<Category>> getAllCategories()
    {
         List<Category> all = categoryRepository.findAll();
         return new SuccessDataResult(true,"all categories has been listed successfully",all);
    }

    @Override
    public DataResult<Category> getById(int id)
    {
         Category category = categoryRepository.findById(id).get();
         return new SuccessDataResult(true,"Category has been listed successfully",category);
    }

    @Override
    public Result deleteExistingRow(Integer id) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        String hostAddress = localHost.getHostAddress();
        categoryRepository.deleteById(id);
        return new SuccessResult(true,"mesaj","ip adresiniz: "+hostAddress);
        //hasBeenDeletedSuccessfully.setIpAddress(hostAddress);

    }
    @Override
    public Result createNewRow(Category category) {
         categoryRepository.save(category);
         return new SuccessResult(true,"has been deleted successfully");

    }

    @Override
    public Result updateRow(Category category) {

            Category tempCategory= getById(category.getCategoryId()).getData();
            tempCategory.setCategoryName(category.getCategoryName());
            tempCategory.setDescription(category.getDescription());
            createNewRow(tempCategory);
            return new SuccessDataResult<>(true,"Category has been updated successfully",tempCategory );
     }
}
