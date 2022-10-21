package kg.manas.sportwear.service;

import kg.manas.sportwear.model.ShopModel;

import java.util.List;

public interface ShopService {
    ShopModel save(ShopModel shop);

    ShopModel get(Long id);

    List<ShopModel> getAll();
}
