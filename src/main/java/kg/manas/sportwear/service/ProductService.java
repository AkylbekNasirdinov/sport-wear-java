package kg.manas.sportwear.service;

import kg.manas.sportwear.model.ProductModel;

import java.util.List;


public interface ProductService {
    ProductModel get(Long id);

    ProductModel save(ProductModel productModel);

    List<ProductModel> getAll();

    ProductModel delete(Long id);
}
