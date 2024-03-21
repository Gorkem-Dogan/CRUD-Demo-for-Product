package northwind.com.Business.Abstracts;

import northwind.com.Business.Request.CreateCategoryRequest;
import northwind.com.Business.Request.DeleteCategoryRequest;
import northwind.com.Business.Request.UpdateCategoryRequest;
import northwind.com.Business.Response.GetAllCategoryResponse;
import northwind.com.Business.Response.GetByIdCategoryResponse;
import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
import northwind.com.Entities.Concrete.Category;
import org.springframework.stereotype.Service;

import java.net.UnknownHostException;
import java.util.List;

@Service
public interface CategoryService {
    Result createNewRow(CreateCategoryRequest category);
    Result updateRow(UpdateCategoryRequest category);
    Result deleteExistingRow(DeleteCategoryRequest id) throws UnknownHostException;
    DataResult<GetByIdCategoryResponse> getById(Integer id);

    DataResult<List<GetAllCategoryResponse>> getAllCategories();

}
