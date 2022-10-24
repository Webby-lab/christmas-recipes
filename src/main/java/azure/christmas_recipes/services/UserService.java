package azure.christmas_recipes.services;

import azure.christmas_recipes.exceptions.EmailAlreadyExistsException;
import azure.christmas_recipes.models.dtos.UserDTO;
import azure.christmas_recipes.models.entities.User;

import java.util.Optional;

public interface UserService {
    UserDTO register(User user) throws EmailAlreadyExistsException, IllegalArgumentException;
    Optional<UserDTO> findById(int id);
    void delete(int userId);
    User update(User user);
}
