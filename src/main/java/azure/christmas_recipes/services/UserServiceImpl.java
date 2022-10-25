package azure.christmas_recipes.services;

import azure.christmas_recipes.exceptions.EmailAlreadyExistsException;
import azure.christmas_recipes.models.dtos.UserDTO;
import azure.christmas_recipes.models.entities.User;
import azure.christmas_recipes.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO register(User user) throws EmailAlreadyExistsException, IllegalArgumentException {
        if (user.getName().trim().isEmpty() || user.getName().trim().length() < 3 ) {
            throw  new IllegalArgumentException("Name should be at least 3 characters");
        }
        Optional<User> userWithSameEmail = userRepository.findByEmail(user.getEmail());
        if (userWithSameEmail.isPresent()) {
        throw new EmailAlreadyExistsException();
        }
        return new UserDTO(userRepository.save(user)) ;
    }

    @Override
    public Optional<UserDTO> findById(int id) {
       Optional<User>  user = userRepository.findById(id);
       if (user.isPresent()) {
           return Optional.of(new UserDTO(user.get()));
       }
        return Optional.empty();
    }

    @Override
    public void delete(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User update(User user) {
        return null;
    }
    @Override
    public List<String> getFavouriteRecipiesName(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get().getFavouriteRecipies().stream()
                .map(recipe -> recipe.getName())
                .collect(Collectors.toList());
    }
}
