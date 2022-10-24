package azure.christmas_recipes.models.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    @OneToMany
    private List<Recipe> favouriteRecipies = new ArrayList<>();

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, List<Recipe> favouriteRecipies) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.favouriteRecipies = favouriteRecipies;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Recipe> getFavouriteRecipies() {
        return favouriteRecipies;
    }

    public void setFavouriteRecipies(List<Recipe> favouriteRecipies) {
        this.favouriteRecipies = favouriteRecipies;
    }
}
