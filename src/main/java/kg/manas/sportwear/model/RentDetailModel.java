package kg.manas.sportwear.model;

import kg.manas.sportwear.enums.RentStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentDetailModel {

    Long id;
    ProductModel productModel;
    Integer amount;
    Long rentId;
    RentStatus rentStatus;
}
