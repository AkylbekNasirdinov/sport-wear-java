package kg.manas.sportwear.service.impl;

import kg.manas.sportwear.entity.Shop;
import kg.manas.sportwear.model.ShopModel;
import kg.manas.sportwear.repository.ShopRepository;
import kg.manas.sportwear.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    @Override
    public ShopModel save(ShopModel shopModel) {
        Shop shop = shopModel.getId() != null ? shopRepository.getById(shopModel.getId()) : new Shop();
        shop.setShopName(shopModel.getShopName());
        shop.setAddress(shopModel.getAddress());
        shop.setPhoneNumber(shopModel.getPhoneNumber());
        return shopRepository.save(shop).toModel();
    }

    @Override
    public ShopModel get(Long id) {
        return shopRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("Shop by id: " + id + "cannot be found !")).toModel();
    }

    @Override
    public List<ShopModel> getAll() {
        return shopRepository.findAll().stream().map(Shop::toModel).collect(Collectors.toList());
    }
}
