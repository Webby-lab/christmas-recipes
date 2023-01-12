package azure.christmas_recipes.services;

import azure.christmas_recipes.exceptions.EmailAlreadyExistsException;
import azure.christmas_recipes.exceptions.NoSuchUserException;
import azure.christmas_recipes.models.dtos.UserDTO;
import azure.christmas_recipes.models.dtos.UserRegistrationDTO;
import azure.christmas_recipes.models.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO register(User user) throws EmailAlreadyExistsException, IllegalArgumentException;

    Optional<UserDTO> findById(int id) throws NoSuchUserException;

    void delete(int userId) throws NoSuchUserException;

    UserDTO update(int userId, UserRegistrationDTO modification) throws NoSuchUserException, IllegalArgumentException;

    List<String> getUserRecipesName(Integer userId);


}
