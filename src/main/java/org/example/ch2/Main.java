package org.example.ch2;

import static org.example.ch2.Color.RED;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, RED));

        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
        System.out.println(greenApples);

        List<Apple> redApples = filterApplesByColor(inventory, RED);
        System.out.println(redApples);

        List<Apple> apples = filterApples(inventory, new AppleWeightPredicate());
        System.out.println(apples);

        List<Apple> green = filterApples(inventory, new AppleColorPredicate());
        System.out.println(green);

        List<Apple> apples1 = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return RED.equals(a.getColor());
            }
        });
        System.out.println(apples1);

        List<Apple> apples2 = filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));
        System.out.println(apples2);

    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor() == color) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple: inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
    interface ApplePredicate {

        boolean test(Apple a);

    }
    static class AppleWeightPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }

    }
    static class AppleColorPredicate implements ApplePredicate{

        @Override
        public boolean test(Apple a) {
            return a.getColor() ==Color.GREEN;
        }
    }

}