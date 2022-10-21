package kg.manas.sportwear.service;

import kg.manas.sportwear.model.RentModel;

import java.util.List;

public interface RentService {
    RentModel get(Long id);

    RentModel save(RentModel rent);

    List<RentModel> getAll();

}
