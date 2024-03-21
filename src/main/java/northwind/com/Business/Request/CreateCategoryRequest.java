package northwind.com.Business.Request;

import lombok.Data;

@Data
public class CreateCategoryRequest
{

    private String categoryName;
    private String description;
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
