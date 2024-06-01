package org.example.ch4;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HighCaloriesNames {

  public static void main(String[] args) {

      List<Dish> lowCaloricDishes = new ArrayList<>();
      for(Dish dish: Dish.menu){
          if(dish.getCalories()<400) lowCaloricDishes.add(dish);
      }
      Collections.sort(lowCaloricDishes,new Comparator<Dish>(){
                  @Override
                  public int compare(Dish dish1, Dish dish2) {
                      return dish1.getCalories()-dish2.getCalories();
                  }
              });
      System.out.println(lowCaloricDishes);

      List<String> lowCaloricDishName = Dish.menu.stream()
              .filter(d->d.getCalories()<400)
              .sorted(comparing(Dish::getCalories))
              .map(Dish::getName)
              .collect(toList());
      System.out.println(lowCaloricDishes);

      System.out.println("=====================================");


      List<String> names = Dish.menu.stream()
              .filter(dish -> {
                  System.out.println("filtering " + dish.getName());
                  return dish.getCalories() > 300;
              })
              .map(dish -> {
                  System.out.println("mapping " + dish.getName());
                  return dish.getName();
              })
              .limit(3)
              .collect(toList());
      System.out.println(names);
  }


}
