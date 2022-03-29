package model.persistence;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface Loader<T>{

  void saveToXml(ArrayList<T> list) throws FileNotFoundException;

  ArrayList<T> loadFromXml();
}
