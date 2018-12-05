package model.sweets;

import java.io.Serializable;

public class Cookie implements Sweet, Serializable {
    private String name;
    private int weight;
    private double cost;
    private String ingredient;

    public Cookie(String name, int weight, double cost, String ingredient) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.ingredient = ingredient;
    }

    public int getWeight() {
        return weight;
    }

    public double getCost() { return cost; }

    public String getName() {
        return name;
    }

    public String getIngredient () { return ingredient; }
}
