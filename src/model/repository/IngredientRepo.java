package model.repository;

import model.entities.Ingredient;
import model.persistence.IngredientLoader;
import java.util.ArrayList;

public class IngredientRepo {

  private ArrayList<Ingredient> ingredients;
  private IngredientLoader loader;

  public IngredientRepo() {
    this.ingredients = new ArrayList<>();
    this.loader = new IngredientLoader();
  }

  public ArrayList<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(ArrayList<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public void save() {
    this.loader.saveToXml(ingredients);
  }

  public void load() {
    setIngredients(loader.loadFromXml());
  }
}
