package kg.manas.sportwear.service.impl;

import kg.manas.sportwear.entity.Category;
import kg.manas.sportwear.entity.Product;
import kg.manas.sportwear.entity.Shop;
import kg.manas.sportwear.model.ProductModel;
import kg.manas.sportwear.repository.CategoryRepository;
import kg.manas.sportwear.repository.ProductRepository;
import kg.manas.sportwear.repository.ShopRepository;
import kg.manas.sportwear.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ShopRepository shopRepository;

    @Override
    public ProductModel get(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product by id: " + id + " cannot be found")).toModel();
    }

    @Override
    public ProductModel save(ProductModel productModel) {
        Category category = categoryRepository.findById(productModel.getCategoryModel().getId()).orElseThrow(() -> new NoSuchElementException("Category by id: " + productModel.getCategoryModel().getId() + " cannot be found"));
        Shop shop = shopRepository.findById(productModel.getShopModel().getId()).orElseThrow(() -> new NoSuchElementException("Shop by id: " + productModel.getShopModel().getId() + " cannot be found"));
        Product product = productModel.getId() != null ?
                productRepository.findById(productModel.getId())
                        .orElseThrow(() -> new NoSuchElementException("Product by id: " + productModel.getId() + " cannot be found")) : new Product();
        product.setProductName(productModel.getProductName());
        product.setCategory(category);
        product.setPrice(productModel.getPrice());
        product.setSeason(productModel.getSeason());
        product.setShop(shop);
        return productRepository.save(product).toModel();
    }

    @Override
    public List<ProductModel> getAll() {
        return productRepository.findAll().stream().map(Product::toModel).collect(Collectors.toList());
    }

    @Override
    public ProductModel delete(Long id) {
        Product product = productRepository.findById(id) .orElseThrow(() -> new NoSuchElementException("Product by id: " + id + " cannot be found"));
        product.markRemoved();
        return productRepository.save(product).toModel();
    }
}
