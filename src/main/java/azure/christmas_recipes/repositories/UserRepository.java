package azure.christmas_recipes.repositories;

import azure.christmas_recipes.models.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();
    Optional<User> findByEmail(String email);
    void deleteById(Integer id);
}
