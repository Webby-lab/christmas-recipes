package azure.christmas_recipes.models.entities;

import javax.persistence.*;

@Entity(name = "ingredients")
public class Ingredient {
    @Id
    private String name;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
    @Enumerated(EnumType.STRING)
    private Unit unit;

    public Ingredient() {
    }

    public Ingredient(String name, Unit unit) {
        this.name = name;
        this.unit = unit;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return name;
    }
}
