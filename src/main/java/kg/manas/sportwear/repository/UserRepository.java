package kg.manas.sportwear.repository;


import kg.manas.sportwear.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndRdtIsNull(String username);

    Optional<List<User>> findAllByRdtIsNull();

    Optional<User> findByIdAndRdtIsNull(Long id);

}
