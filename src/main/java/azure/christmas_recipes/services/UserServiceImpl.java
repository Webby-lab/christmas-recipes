package azure.christmas_recipes.services;

import azure.christmas_recipes.exceptions.EmailAlreadyExistsException;
import azure.christmas_recipes.exceptions.NoSuchUserException;
import azure.christmas_recipes.models.dtos.UserDTO;
import azure.christmas_recipes.models.dtos.UserRegistrationDTO;
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
    public Optional<UserDTO> findById(int id) throws NoSuchUserException {
       Optional<User>  user = userRepository.findById(id);
        if (!user.isPresent()) throw  new NoSuchUserException();
           return Optional.of(new UserDTO(user.get()));
    }

    @Override
    public void delete(int userId) throws NoSuchUserException {
        try {
            userRepository.deleteById(userId);
        } catch (Exception e) {
            throw new NoSuchUserException();
        }

    }

    @Override
    public UserDTO update(int userId, UserRegistrationDTO modification) throws NoSuchUserException, IllegalArgumentException {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) throw new NoSuchUserException();
        User modifiedUser = modifyUser(user.get(), modification);
        userRepository.save(modifiedUser);
        return new UserDTO(modifiedUser);
    }

    public User modifyUser(User user, UserRegistrationDTO modification) throws IllegalArgumentException {
        if (modification.getName()!= null && isNameValid(modification.getName())) {
            user.setName(modification.getName());
        }
        if (modification.getEmail() != null && isEmailValid(modification.getEmail())) {
            user.setEmail(modification.getEmail());
        }
        if (modification.getPassword() != null && isPasswordValid(modification.getPassword())) {
            user.setPassword(modification.getPassword());
        }
        return user;
    }


    @Override
    public List<String> getFavouriteRecipiesName(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.get().getFavouriteRecipies().stream()
                .map(recipe -> recipe.getName())
                .collect(Collectors.toList());
    }


    public void validate(UserRegistrationDTO userData) throws IllegalArgumentException {
        isNameValid(userData.getName());
        isEmailValid(userData.getEmail());
        isPasswordValid(userData.getEmail());
        }

    public boolean isNameValid(String name) throws IllegalArgumentException {
        if (name.trim().isEmpty() || name.trim().length() < 3 ) {
            throw  new IllegalArgumentException("Name should be at least 3 characters");
        }
        return true;
    }
    public boolean isEmailValid(String email) throws IllegalArgumentException{
        return true;
    }
    public boolean isPasswordValid(String email) throws IllegalArgumentException{
        return true;
    }
}
