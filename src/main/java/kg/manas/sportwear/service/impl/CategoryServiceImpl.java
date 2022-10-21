package kg.manas.sportwear.service.impl;

import kg.manas.sportwear.entity.Category;
import kg.manas.sportwear.model.CategoryModel;
import kg.manas.sportwear.repository.CategoryRepository;
import kg.manas.sportwear.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public CategoryModel get(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Category by id: " + id + " cannot be found !"))
                .toModel();
    }

    @Override
    public CategoryModel save(CategoryModel categoryModel) {
        Category category = categoryModel.getId() == null ? new Category() : categoryRepository.getById(categoryModel.getId());
        category.setCategoryName(categoryModel.getCategoryName());
        return categoryRepository.save(category).toModel();
    }

    @Override
    public List<CategoryModel> getAll() {
        return categoryRepository.findAll().stream()
                .map(Category::toModel).collect(Collectors.toList());
    }
}
