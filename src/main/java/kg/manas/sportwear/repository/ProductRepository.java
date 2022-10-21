package kg.manas.sportwear.repository;

import kg.manas.sportwear.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
