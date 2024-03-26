package northwind.com.Business.Abstracts;

import northwind.com.Business.Request.Category.CreateCategoryRequest;
import northwind.com.Business.Request.Category.DeleteCategoryRequest;
import northwind.com.Business.Request.Category.UpdateCategoryRequest;
import northwind.com.Business.Response.Category.GetAllCategoryResponse;
import northwind.com.Business.Response.Category.GetByIdCategoryResponse;
import northwind.com.Core.Result.DataResult;
import northwind.com.Core.Result.Result;
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
