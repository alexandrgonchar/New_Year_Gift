package model.sweets;

import java.io.Serializable;

public class Candy implements Sweet, Serializable {
    private String name;
    private String filling;
    private int weight;
    private double cost;

    public Candy (String name, int weight, double cost, String filling) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.filling = filling;
    }

    public int getWeight() {
        return weight;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getFilling () { return filling; }
}
