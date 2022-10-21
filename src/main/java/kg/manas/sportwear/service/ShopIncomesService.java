package kg.manas.sportwear.service;

import kg.manas.sportwear.model.ShopIncomesModel;
import org.springframework.http.ResponseEntity;

import java.time.Month;
import java.time.Year;
import java.util.List;

public interface ShopIncomesService {

    ResponseEntity<ShopIncomesModel> save(ShopIncomesModel shopIncomes);

    ResponseEntity<List<ShopIncomesModel>> getIncomesForMonth(Month month);

    ResponseEntity<List<ShopIncomesModel>> getIncomesForYear(Year year);

}
