package kg.manas.sportwear.model;

import kg.manas.sportwear.entity.Rent;
import kg.manas.sportwear.entity.Shop;
import lombok.*;

import java.time.Month;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopIncomesModel {

    Long id;
    ShopModel shop;
    Month month;
    RentModel rent;
}
