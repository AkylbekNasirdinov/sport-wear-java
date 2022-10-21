package kg.manas.sportwear.service;


import kg.manas.sportwear.model.RequestNewUser;
import kg.manas.sportwear.model.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    ResponseEntity<?> register(RequestNewUser user);

    ResponseEntity<?> getUser(Long id);

    List<UserDTO> getAllUser();

    ResponseEntity<?> deleteUser(Long id);

    ResponseEntity<?> update(Long id, RequestNewUser updatedUser);
}
