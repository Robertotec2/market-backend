package mx.edu.tecdesoftware.market_backend_2026_3_A.Domain;

public class Category {

    private int categoryId;
    private String category;
    public boolean active;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
