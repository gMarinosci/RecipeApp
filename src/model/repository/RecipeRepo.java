package model.repository;

import model.entities.Recipe;
import model.persistence.RecipeLoader;
import java.util.ArrayList;

public class RecipeRepo {

  private ArrayList<Recipe> recipes;
  private RecipeLoader loader;

  public RecipeRepo() {
    this.recipes = new ArrayList<>();
    this.loader = new RecipeLoader();
  }

  public ArrayList<Recipe> getRecipes() {
    return recipes;
  }

  public void setRecipes(ArrayList<Recipe> recipes) {
    this.recipes = recipes;
  }

  public void save() {
    loader.saveToXml(recipes);
  }

  public void load() {
    setRecipes(loader.loadFromXml());
  }
}
