package azure.christmas_recipes.models.entities;

import azure.christmas_recipes.models.entities.Level;
import azure.christmas_recipes.models.entities.User;

import javax.persistence.*;

@Entity(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(length = 5000)
    private String description;
    @Column(name = "cooking_time")
    private Double cookingTime;
    @Enumerated(EnumType.STRING)
    private Level level;


    public Recipe() {
    }

    public Recipe(String name, String description, Double cookingTime, Level level) {
        this.name = name;
        this.description = description;
        this.cookingTime = cookingTime;
        this.level = level;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Double cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

}
