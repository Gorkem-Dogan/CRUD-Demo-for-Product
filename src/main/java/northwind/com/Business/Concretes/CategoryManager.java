package northwind.com.Business.Concretes;

import northwind.com.Business.Abstracts.CategoryService;
import northwind.com.Business.Request.CreateCategoryRequest;
import northwind.com.Business.Request.DeleteCategoryRequest;
import northwind.com.Business.Request.UpdateCategoryRequest;
import northwind.com.Business.Response.GetAllCategoryResponse;
import northwind.com.Business.Response.GetByIdCategoryResponse;
import northwind.com.Core.Mapping.ModelMapperService;
import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
import northwind.com.Core.Result.SuccessDataResult;
import northwind.com.Core.Result.SuccessResult;
import northwind.com.DataAccess.CategoryRepository;
import northwind.com.Entities.Concrete.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryManager implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapperService modelMapperService;

    @Override
     public DataResult<List<GetAllCategoryResponse>> getAllCategories()
    {
         List<Category> all = categoryRepository.findAll();
         final List<GetAllCategoryResponse> collect = all.stream().map(category -> this.modelMapperService.forResponce().map(category, GetAllCategoryResponse.class)).collect(Collectors.toList());

//         List<GetAllCategoryResponse> getAllCategoryResponses = new ArrayList<>();
//        for(Category category:all)
//        {
//         GetAllCategoryResponse tempCategoryResponse = new GetAllCategoryResponse(category.getCategoryId(),category.getCategoryName(),category.getDescription());
//         getAllCategoryResponses.add(tempCategoryResponse);
//        }
        return new SuccessDataResult<>(true,"all categories has been listed successfully",collect);
    }

    @Override
    public DataResult<GetByIdCategoryResponse> getById(Integer id)
    {
        Category category = categoryRepository.findById(id).get();
        GetByIdCategoryResponse getByIdCategoryResponse = this.modelMapperService.forResponce().map(category, GetByIdCategoryResponse.class);
        return new SuccessDataResult<>(true,"Category has been listed successfully",getByIdCategoryResponse);
    }

    @Override
    public Result deleteExistingRow(DeleteCategoryRequest request) throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        String hostAddress = localHost.getHostAddress();
        categoryRepository.deleteById(request.getCategoryId());
        return new SuccessResult(true,"mesaj","ip adresiniz: "+hostAddress);
        //hasBeenDeletedSuccessfully.setIpAddress(hostAddress);

    }
    @Override
    public Result createNewRow(CreateCategoryRequest category) {
//        old usage of modelMapping
//        Category tempCategory = new Category();
//        tempCategory.setCategoryName(category.getCategoryName());
//        tempCategory.setDescription(category.getDescription());
        Category tempCategory = this.modelMapperService.forRequest().map(category, Category.class);
        Category save = categoryRepository.save(tempCategory);
        return new SuccessResult(true,"has been created successfully");

    }

    @Override
    public Result updateRow(UpdateCategoryRequest category) {

        Category tempCategory = this.modelMapperService.forRequest().map(category, Category.class);
        categoryRepository.save(tempCategory);
            return new SuccessDataResult<>(true,"Category has been updated successfully",tempCategory );
     }
}

