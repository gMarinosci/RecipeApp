package controller;

import model.entities.Ingredient;
import model.entities.Recipe;
import model.repository.IngredientRepo;
import model.repository.RecipeRepo;
import view.View;
import java.util.Comparator;
import java.util.List;

public class UserSession {
  public void run(IngredientRepo ingredientRepo, RecipeRepo recipeRepo, View view) {

    boolean status = true;
    view.printMainMenu();

    while (status) {

      switch (view.mainMenu()) {

        case INGREDIENTS:
          listIngredients(ingredientRepo, view);
          ingredientMenu(ingredientRepo, view);
          break;

        case RECIPES:
          listRecipes(recipeRepo, view);
          recipeMenu(recipeRepo, view);
          break;

        case QUIT:
          status = false;
          break;

        default:
          System.err.println("Something went wrong bro.");
      }
    }
  }

  public void ingredientMenu(IngredientRepo ingredientRepo, View view) {
    view.printIngredientMenu();

    switch (view.ingredientMenu()) {

      case ADD:
        //TODO: add ingredient
        break;

      case SHOW:
        //TODO: show ingredient
        break;

      case MAIN_MENU:
        break;

      default:
        System.err.println("Something went wrong bro.");
    }
  }

  public void recipeMenu(RecipeRepo recipeRepo, View view) {
    view.printRecipeMenu();

    switch (view.recipeMenu()) {

      case ADD:
        //TODO: add recipe
        break;

      case SHOW:
        //TODO: show recipe
        break;

      case DELETE:
        //TODO: delete recipe

      case MAIN_MENU:
        break;

      default:
        System.err.println("Something went wrong bro.");
    }
  }

  public void listIngredients(IngredientRepo ingredientRepo, View view) {
    //TODO: list all available ingredients
    List<Ingredient> ingredients = ingredientRepo.getIngredients();
    ingredients.sort(Comparator.comparing(Ingredient::getName)) ;

  }

  public void listRecipes(RecipeRepo recipeRepo, View view) {
    //TODO: list all available recipes
    List<Recipe> recipes = recipeRepo.getRecipes();
    recipes.sort(Comparator.comparing(Recipe::getName));
  }
}
