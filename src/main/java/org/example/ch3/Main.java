package org.example.ch3;

import static java.util.Comparator.comparing;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>(Arrays.asList
                (new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED)));

        inventory.sort(new AppleComparator());
        System.out.println(inventory);
        inventory.set(1, new Apple(20, Color.RED));

        //익명
        inventory.sort(new Comparator<Apple>(){
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight()-o2.getWeight();
            }
        });
        System.out.println(inventory);
        inventory.set(1, new Apple(20, Color.RED));

        //람다

        inventory.sort((Apple a1,Apple a2)->a1.getWeight()-a2.getWeight());
        System.out.println(inventory);
        inventory.set(1, new Apple(20, Color.RED));

        //메서드 참조
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);

        //역정렬
        inventory.sort(comparing(Apple::getWeight).reversed());
        // 무게가 같은 경우 색깔별로 사과 정렬
        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor)
        );




    }

    static class AppleComparator implements Comparator<Apple>{

        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight() - a2.getWeight();
        }
    }




}
