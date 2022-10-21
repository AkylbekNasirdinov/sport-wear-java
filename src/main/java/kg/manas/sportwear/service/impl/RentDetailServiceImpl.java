package kg.manas.sportwear.service.impl;

import kg.manas.sportwear.entity.Product;
import kg.manas.sportwear.entity.Rent;
import kg.manas.sportwear.entity.RentDetail;
import kg.manas.sportwear.model.RentDetailModel;
import kg.manas.sportwear.repository.ProductRepository;
import kg.manas.sportwear.repository.RentDetailRepository;
import kg.manas.sportwear.repository.RentRepository;
import kg.manas.sportwear.service.RentDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentDetailServiceImpl implements RentDetailService {

    private final RentDetailRepository rentDetailRepository;
    private final RentRepository rentRepository;
    private final ProductRepository productRepository;

    @Override
    public RentDetailModel save(RentDetailModel rentDetailModel) {
        RentDetail rentDetail = rentDetailModel.getId() != null ? rentDetailRepository.findById(rentDetailModel.getId())
                .orElseThrow(()-> new NoSuchElementException("rent detail by id: " + rentDetailModel.getId() + " can not be found !" )) : new RentDetail();
        Rent rent = rentRepository.findById(rentDetailModel.getRentId()).orElseThrow(()-> new NoSuchElementException("rent by id: " + rentDetailModel.getRentId() + " can not be found !"));
        Product product = productRepository.findById(rentDetailModel.getProductModel().getId()).orElseThrow(()-> new NoSuchElementException("product by id: " + rentDetailModel.getProductModel().getId() + " can not be found !"));

        rentDetail.setRent(rent);
        rentDetail.setAmount(rentDetailModel.getAmount());
        rentDetail.setRentStatus(rentDetailModel.getRentStatus());
        rentDetail.setProduct(product);
        return rentDetailRepository.save(rentDetail).toModel();
    }

    @Override
    public List<RentDetailModel> getAllByRentId(Long id) {
        return rentDetailRepository.findAllByRentId(id).stream().map(RentDetail::toModel).collect(Collectors.toList());
    }

    @Override
    public List<RentDetailModel> getAll() {
        return rentDetailRepository.findAll().stream().map(RentDetail::toModel).collect(Collectors.toList());

    }
}
