package view;

import model.entities.Ingredient;
import model.entities.Recipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

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

      case '1':
        return MainActions.INGREDIENTS;

      case '2':
        return MainActions.RECIPES;

      case '3':
        return MainActions.QUIT;

      default:
        System.err.println("Wrong input, please try again: ");
        return mainMenu();
    }
  }
  public IngredientActions ingredientMenu() {
    switch (getInput()) {

      case '1':
        return IngredientActions.ADD;

      case '2':
        return IngredientActions.SHOW;

      case '3':
        return IngredientActions.DELETE;

      case '4':
        return IngredientActions.MAIN_MENU;

      default:
        System.err.println("Wrong input, please try again");
        return ingredientMenu();
    }
  }

  public RecipeActions recipeMenu() {
    switch (getInput()) {

      case '1':
        return RecipeActions.ADD;

      case '2':
        return RecipeActions.SHOW;

      case '3':
        return RecipeActions.DELETE;

      case '4':
        return RecipeActions.MAIN_MENU;

      default:
        System.err.println("Wrong input, please try again.");
        return recipeMenu();
    }
  }

  public Ingredient newIngredientForm() {
    System.out.println("Please enter the details of the new ingredient.");
    System.out.println("Name: ");
    readInput();
    String name = readInput();
    if (name.length() == 0) return null;

    System.out.println("Unit of measure: ");
    String unit = readInput();
    if (unit.length() == 0) return null;

    System.out.println("Price: ");
    double price = checkInteger();
    if (price == -1) return null;

    System.out.println("Would you like to save this ingredient? (y/n) - ");

    switch (getInput()) {
      case 'y':
        return new Ingredient(name, unit, price);

      case 'n':
        return null;

      default:
        System.err.println("Something went wrong bro");
        return null;
    }
  }

  public void printIngredientList(List<Ingredient> ingredients) {
    for (Ingredient i: ingredients) {
      System.out.println(i.getName().toUpperCase());
      System.out.println("Unit: " + i.getUnit());
      System.out.println("Price: " + i.getPrice());
      System.out.println();
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

  public String readInput() {
    try {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "Cp850"));

      try {
        return input.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      }

    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    return "";
  }

  public double checkInteger() {
    String value = readInput();
    if (value.length() == 0) return -1;

    try {
      return Double.parseDouble(value);
    } catch (NumberFormatException e) {
      System.err.println("Wrong input, please enter a numeric value.");
      System.out.println("Price: ");
    }

    return checkInteger();
  }
}
