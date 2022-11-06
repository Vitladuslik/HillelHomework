package HW7;

import java.util.Arrays;

public class Main {

    public static String[] arr;

    public static void main(String[] args) {

        ArrayServiceImpl service = new ArrayServiceImpl();

        //стартовий масив
        arr = new String[]{"1", "2", "3", "4", "5", "6"};


        //стартовий масив
        System.out.println("Array we have: " + Arrays.toString(arr));
        System.out.println("--------------------------------------");

        //тест методу 'add(value)'
        service.add("9");
        System.out.println("Array after 'add': " + Arrays.toString(arr));
        System.out.println("--------------------------------------");

//        //тест методу 'add(index, value)'
//        service.add(6, "7");
//        System.out.println("Array after 'add': " + arrList);
//        System.out.println("--------------------------------------");
//
//        //тест методу 'delete(index)'
//        service.delete(6);
//        System.out.println("Array after 'delete': " + arrList);
//        System.out.println("--------------------------------------");
//
//        //тест методу 'delete(value)'
//        service.delete("9");
//        System.out.println("Array after 'delete': " + arrList);
//        System.out.println("--------------------------------------");
//
//        //повертаємо значення елементу колекції по індексу
//        System.out.println("Sixth element is: " + service.get(5));


    }

}
