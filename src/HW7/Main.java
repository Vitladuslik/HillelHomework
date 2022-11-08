package HW7;

public class Main {

    public static String[] arr;

    public static void main(String[] args) {

        //стартовий масив
        arr = new String[]{"1", "2", "3", "4", "5", "6"};

        ArrayServiceImpl service = new ArrayServiceImpl(arr);


        // виведемо стартовий масив
        System.out.println("Array we have: " + service);
        System.out.println("--------------------------------------");

        //тест методу 'add(value)'
        service.add("9");
        System.out.println("Array after 'add': " + service);
        System.out.println("--------------------------------------");

        //тест методу 'add(index, value)'
        service.add(6, "7");
        System.out.println("Array after 'add': " + service);
        System.out.println("--------------------------------------");

        //тест методу 'delete(index)'
        service.delete(4);
        System.out.println("Array after 'delete': " + service);
        System.out.println("--------------------------------------");

        //тест методу 'delete(value)'
        service.delete("3");
        System.out.println("Array after 'delete': " + service);
        System.out.println("--------------------------------------");

        //повертаємо значення елементу колекції по індексу
        System.out.println("The third element is: " + service.get(2));



    }

}
