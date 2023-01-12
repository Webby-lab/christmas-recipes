package azure.christmas_recipes.models.dtos;

import azure.christmas_recipes.models.entities.Recipe;
import azure.christmas_recipes.models.entities.User;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private Integer id;
    private String name;
    private String email;
    private List<String> userRecipes = new ArrayList<>();

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.userRecipes = user.getUserRecipes().stream()
                .map(recipe -> recipe.getName())
                .collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getUserRecipes() {
        return userRecipes;
    }

    public void setUserRecipes(List<String> userRecipes) {
        this.userRecipes = userRecipes;
    }
}
