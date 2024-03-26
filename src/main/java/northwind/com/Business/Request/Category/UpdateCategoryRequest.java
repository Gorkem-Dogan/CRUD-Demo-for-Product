package northwind.com.Business.Request.Category;

import lombok.Data;

@Data
public class UpdateCategoryRequest
{

    private Integer categoryId;
    private String categoryName;
    private String description;
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
