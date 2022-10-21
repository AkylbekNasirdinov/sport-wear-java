package kg.manas.sportwear.entity;



import com.sun.istack.NotNull;
import kg.manas.sportwear.enums.RentStatus;
import kg.manas.sportwear.model.RentDetailModel;
import kg.manas.sportwear.service.RentDetailService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "RENT_DETAILS")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RentDetail extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RENT_DETAIL_SEQ")
    @SequenceGenerator(name = "SEQ_ID", sequenceName = "RENT_DETAIL_SEQ", allocationSize = 1, initialValue = 10)
    Long id;

    @ManyToOne
    @NotNull
    Product product;

    @ManyToOne
    @NotNull
    Rent rent;

    @Column(name = "AMOUNT")
    @NotNull
    Integer amount;

    @Column(name = "RENT_STATUS")
    @NotNull
    RentStatus rentStatus;

    public RentDetailModel toModel() {
        return RentDetailModel.builder()
                .id(id)
                .productModel(product.toModel())
                .rentId(rent.getId())
                .amount(amount)
                .rentStatus(rentStatus)
                .build();
    }
}

