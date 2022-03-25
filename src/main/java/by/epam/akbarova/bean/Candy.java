package by.epam.akbarova.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Candy {
    private String name;
    private int energy;
    private List<Ingredient> ingredientList = new ArrayList<>();
    private Value value;
    private String production;
    private LocalDate date = LocalDate.of(2022, 03, 19);


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Candy{" +
                "name='" + name + '\'' +
                ", energy=" + energy +
                ", ingredientList=" + ingredientList +
                ", value=" + value +
                ", production='" + production + '\'' +
                ", date=" + date +
                '}';
    }

    public void setIngredient(Ingredient ingred) {
    }
}
