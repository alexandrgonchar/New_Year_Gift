package model.sweets;

import java.io.Serializable;

public class CandyBar implements Sweet, Serializable {
    private String name;
    private int weight;
    private double cost;
    private String wrapper;

    public CandyBar (String name, int weight, double cost, String wrapper) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.wrapper = wrapper;
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

    public String getWrapper () { return wrapper; }
}
