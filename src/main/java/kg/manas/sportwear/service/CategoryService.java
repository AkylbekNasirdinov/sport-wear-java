package kg.manas.sportwear.service;

import kg.manas.sportwear.model.CategoryModel;

import java.util.List;


public interface CategoryService {
    CategoryModel get(Long id);

    CategoryModel save(CategoryModel categoryModel);

    List<CategoryModel> getAll();

}
