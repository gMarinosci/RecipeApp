package model.entities;

import java.util.List;

public class Recipe {

  private List<RecipeLabel> labels;
  private List<Ingredient> ingredients;
  private String name;
  private String instructions;

  //no args constructor
  public Recipe() {
  }

  //all args constructor
  public Recipe(List<RecipeLabel> labels, List<Ingredient> ingredients, String name, String instructions) {
    this.labels = labels;
    this.ingredients = ingredients;
    this.name = name;
    this.instructions = instructions;
  }

  public List<RecipeLabel> getLabels() {
    return labels;
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public String getName() {
    return name;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setLabels(List<RecipeLabel> labels) {
    this.labels = labels;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }
}
