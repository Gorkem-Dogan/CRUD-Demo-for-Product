package northwind.com.Business.Request;

import lombok.Data;

@Data
public class DeleteCategoryRequest
{
    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
