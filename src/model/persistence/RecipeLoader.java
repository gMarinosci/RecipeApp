package model.persistence;

import model.entities.Recipe;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

public class RecipeLoader implements Loader<Recipe>{

  @Override
  public void saveToXml(ArrayList<Recipe> list) {

    try {

      FileOutputStream file = new FileOutputStream("src/model/persistence/files/recipes.xml");
      XMLEncoder encoder = new XMLEncoder(file);

      encoder.writeObject(list);
      encoder.close();
      file.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public ArrayList<Recipe> loadFromXml() {
    File file = new File("src/model/persistence/files/ingredients.xml");
    ArrayList<Recipe> recipes = new ArrayList<>();

    try {
      FileInputStream inputStream = new FileInputStream(file);
      XMLDecoder decoder = new XMLDecoder(inputStream);

      if (file.length() == 0) {
        return recipes;
      } else {
        recipes = (ArrayList<Recipe>) decoder.readObject();
      }

      decoder.close();
      inputStream.close();

    } catch (IOException e){
      e.printStackTrace();
    }

    return recipes;
  }
}
