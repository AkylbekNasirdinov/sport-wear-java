package kg.manas.sportwear.entity;


import kg.manas.sportwear.enums.Season;
import kg.manas.sportwear.model.ProductModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SEQ")
    @SequenceGenerator(name = "SEQ_ID", sequenceName = "ROLE_SEQ", allocationSize = 1, initialValue = 10)
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private Category category;

    @Column(name = "SEASON")
    private Season season;

    @ManyToOne
    @JoinColumn(name = "SHOP_ID", referencedColumnName = "ID")
    private Shop shop;

    @Column(name = "PRICE")
    private Double price;

    public ProductModel toModel(){
        return ProductModel.builder()
                .id(id)
                .categoryModel(category.toModel())
                .season(season)
                .shopModel(shop.toModel())
                .price(price)
                .build();
    }


}
