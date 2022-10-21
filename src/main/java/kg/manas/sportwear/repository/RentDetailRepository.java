package kg.manas.sportwear.repository;

import kg.manas.sportwear.entity.RentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentDetailRepository extends JpaRepository<RentDetail, Long> {

    List<RentDetail> findAllByRentId(Long id);
}
