package model.entities;

public class Ingredient {

  private String name;
  private String unit;
  private double price;
  private IngredientLabel label;

  //all args constructor
  public Ingredient(String name, String unit, double price, IngredientLabel label) {
    this.name = name;
    this.unit = unit;
    this.price = price;
    this.label = label;
  }

  //no args constructor
  public Ingredient() {
  }

  public String getName() {
    return name;
  }

  public String getUnit() {
    return unit;
  }

  public double getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public void setPrice(double price) {
    this.price = price;
  }
}
