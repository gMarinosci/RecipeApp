package view;

import model.entities.Recipe;

public class View {

  public enum MainActions {
    INGREDIENTS, RECIPES, QUIT
  }

  public enum IngredientActions {
    ADD, SHOW, DELETE, MAIN_MENU
  }

  public enum RecipeActions {
    ADD, SHOW, DELETE, MAIN_MENU
  }
  public void printMainMenu() {
    System.out.println("********** myRecipeBook v1 **********\n\n");
    System.out.println("1. List all available ingredients.");
    System.out.println("2. List all available recipes ");
    System.out.println("3. Quit.");
  }

  public void printIngredientMenu(){
    System.out.println("1. Add an ingredient.");
    System.out.println("2. List details of an ingredients.");
    System.out.println("3. Delete an ingredient.");
    System.out.println("4. Back to main menu.");
  }

  public void printRecipeMenu() {
    System.out.println("1. Add a recipe.");
    System.out.println("2. List details of a recipe.");
    System.out.println("3. Delete a recipe.");
    System.out.println("4. Back to main menu.");
  }

  public MainActions mainMenu() {
    switch (getInput()) {

      case 1:
        return MainActions.INGREDIENTS;

      case 2:
        return MainActions.RECIPES;

      case 3:
        return MainActions.QUIT;

      default:
        System.err.println("Wrong input, please try again: ");
        return mainMenu();
    }
  }
  public IngredientActions ingredientMenu() {
    switch (getInput()) {

      case 1:
        return IngredientActions.ADD;

      case 2:
        return IngredientActions.SHOW;

      case 3:
        return IngredientActions.DELETE;

      case 4:
        return IngredientActions.MAIN_MENU;

      default:
        System.err.println("Wrong input, please try again");
        return ingredientMenu();
    }
  }

  public RecipeActions recipeMenu() {
    switch (getInput()) {

      case 1:
        return RecipeActions.ADD;

      case 2:
        return RecipeActions.SHOW;

      case 3:
        return RecipeActions.DELETE;

      case 4:
        return RecipeActions.MAIN_MENU;

      default:
        System.err.println("Wrong input, please try again.");
        return recipeMenu();
    }
  }

  public int getInput() {
    try {
      int c = System.in.read();
      while (c == '\r' || c == '\n') {
        c = System.in.read();
      }
      return c;
    } catch (java.io.IOException e) {
      System.out.println("" + e);
      return 0;
    }
  }

}
