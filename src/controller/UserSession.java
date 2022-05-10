package controller;

import model.entities.Ingredient;
import model.entities.Recipe;
import model.repository.IngredientRepo;
import model.repository.RecipeRepo;
import view.View;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
        addIngredient(ingredientRepo, view);
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
    if (!ingredients.isEmpty()) {
      ingredients.sort(Comparator.comparing(Ingredient::getName)) ;
      view.printIngredientList(ingredients);
    } else {
      System.out.println("** no available ingredients **");
    }

  }

  public void listRecipes(RecipeRepo recipeRepo, View view) {
    //TODO: list all available recipes
    List<Recipe> recipes = recipeRepo.getRecipes();
    recipes.sort(Comparator.comparing(Recipe::getName));
  }

  public void addIngredient(IngredientRepo ingredientRepo, View view) {
    Optional<Ingredient> newIngredient = Optional.ofNullable(view.newIngredientForm());

    newIngredient.ifPresentOrElse( ingredient -> { ingredientRepo.getIngredients().add(ingredient); },
            () -> { System.out.println("Operation cancelled.."); });
  }
}
