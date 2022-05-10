package controller;

import model.repository.IngredientRepo;
import model.repository.RecipeRepo;
import view.View;

public class App {

  public static void main(String[] args) {

    IngredientRepo ingredientRepo = new IngredientRepo();
    RecipeRepo recipeRepo = new RecipeRepo();
    View view = new View();
    UserSession userSession = new UserSession();

    ingredientRepo.load();
    recipeRepo.load();

    userSession.run(ingredientRepo, recipeRepo, view);

    ingredientRepo.save();
    recipeRepo.save();
  }
}
