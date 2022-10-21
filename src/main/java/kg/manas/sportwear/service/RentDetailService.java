package kg.manas.sportwear.service;

import kg.manas.sportwear.model.RentDetailModel;

import java.util.List;

public interface RentDetailService {
    RentDetailModel save(RentDetailModel rentDetailModel);
    List<RentDetailModel> getAllByRentId(Long id);
    List<RentDetailModel> getAll();
}
