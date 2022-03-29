package model.persistence;

import model.entities.Ingredient;
import model.entities.Recipe;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class IngredientLoader implements Loader<Ingredient>{

  @Override
  public void saveToXml(ArrayList<Ingredient> list) {
    try {

      FileOutputStream file = new FileOutputStream("src/model/persistence/files/ingredients.xml");
      XMLEncoder encoder = new XMLEncoder(file);

      encoder.writeObject(list);
      encoder.close();
      file.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public ArrayList<Ingredient> loadFromXml() {
    File file = new File("src/model/persistence/files/ingredients.xml");
    ArrayList<Ingredient> ingredients = new ArrayList<>();

    try {
      FileInputStream inputStream = new FileInputStream(file);
      XMLDecoder decoder = new XMLDecoder(inputStream);

      if (file.length() == 0) {
        return ingredients;
      } else {
        ingredients = (ArrayList<Ingredient>) decoder.readObject();
      }

      decoder.close();
      inputStream.close();

    } catch (IOException e){
      e.printStackTrace();
    }

    return ingredients;
  }
}
