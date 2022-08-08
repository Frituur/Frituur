package be.thomasmore.graduaten.hellospring.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {
    private List<CategoryDto> categories;

    public CategoryList() {
        categories = new ArrayList<>();
    }
}
