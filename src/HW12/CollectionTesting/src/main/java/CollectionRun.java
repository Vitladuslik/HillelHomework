public class CollectionRun {

    public static void main(String[] args) {

        //стартовий масив
        String[] arr = new String[]{"1", "2", "3", "4", "5", "6"};

        //об'єкт класу сервісу
        CollectionImpl service = new CollectionImpl(arr);

        // виведемо стартовий масив
        System.out.println("Array we have: " + service);
        System.out.println("--------------------------------------");

        //тест методу 'add(value)'
        System.out.println("Array size is : " + service.size());
        service.add("9");
        System.out.println("Array after 'add(\"9\")': " + service);
        System.out.println("Array size is : " + service.size());
        System.out.println("--------------------------------------");

        //тест методу 'add(index, value)'
        service.add(6, "7");
        System.out.println("Array after 'add(6, \"7\")': " + service);
        System.out.println("Array size is : " + service.size());
        System.out.println("--------------------------------------");

        //тест методу 'delete(value)'
        service.delete("3");
        System.out.println("Array after 'delete(\"3\")': " + service);
        System.out.println("Array size is : " + service.size());
        System.out.println("--------------------------------------");

        //повертаємо значення елементу колекції по індексу
        System.out.println("The third element is: " + service.get(2));
        System.out.println("--------------------------------------");

        //перевіряємо чи є в масиві вказаний елемент
        System.out.println("Check if array contains '2' : " + service.contain("2"));
        System.out.println("--------------------------------------");

        //перевірка чи дорівнюе масив заданому масиву
        String[] testArr1 = new String[]{"a", "b", "c", "d", "e", "f"};
        CollectionImpl service1 = new CollectionImpl(testArr1);
        System.out.println("Check if array equals array in 'service1' : " + service.equals(service1));
        System.out.println("--------------------------------------");

        //тест методу 'clear()'
        service.clear();
        System.out.println("Array after 'clear()': " + service);
        System.out.println("Array size is : " + service.size());
        System.out.println("--------------------------------------");


    }

}
