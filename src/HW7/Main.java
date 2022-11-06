package HW7;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static ArrayList<String> arrList;

    public static void main(String[] args) {

        ArrayListServiceImpl service = new ArrayListServiceImpl();

        //стартовий масив
        String[] arr = new String[]{"1", "2", "3", "4", "5", "6"};

        arrList = new ArrayList<>();

        //переносимо елементи масиву в колекцію
        Collections.addAll(arrList, arr);

        //стартова колекція
        System.out.println("Array we have: " + arrList);
        System.out.println("--------------------------------------");

        //тест методу 'add(value)'
        service.add("9");
        System.out.println("Array after 'add': " + arrList);
        System.out.println("--------------------------------------");

        //тест методу 'add(index, value)'
        service.add(6, "7");
        System.out.println("Array after 'add': " + arrList);
        System.out.println("--------------------------------------");

        //тест методу 'delete(index)'
        service.delete(6);
        System.out.println("Array after 'delete': " + arrList);
        System.out.println("--------------------------------------");

        //тест методу 'delete(value)'
        service.delete("9");
        System.out.println("Array after 'delete': " + arrList);
        System.out.println("--------------------------------------");

        //повертаємо значення елементу колекції по індексу
        System.out.println("Sixth element is: " + service.get(5));


    }

}
