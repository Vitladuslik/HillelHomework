package HW9;


import java.util.ArrayList;
import java.util.Collection;

public class Run {

    public static void main(String[] args) {

        CustomCollectionImpl test = new CustomCollectionImpl();

        //тест методу 'add(String str)'
        System.out.println("Collection size is : " + test.size());
        test.add("a");
        System.out.println("Collection size after 'add(\"a\")': " + test.size());
        test.add("b");
        System.out.println("Collection size after 'add(\"a\")': " + test.size());
        test.add("c");
        System.out.println("Collection size after 'add(\"a\")': " + test.size());
        System.out.println("--------------------------------------");


        //тест методу 'addAll(Collection <String> strColl)'
        Collection <String> testColl = new ArrayList<>();
        testColl.add("d");
        testColl.add("e");
        test.addAll(testColl);
        System.out.println("Collection size after 'addAll(testColl)': " + test.size());
        System.out.println("--------------------------------------");

        //тест методу 'delete(String str)'
        test.delete("c");
        System.out.println("Collection size after 'delete(\"c\")': " + test.size());
        System.out.println("--------------------------------------");

        //тест методу 'delete(int index)'
        test.delete(1);
        System.out.println("Collection size after 'delete(1)': " + test.size());
        System.out.println("--------------------------------------");

        System.out.println("The first element is: " + test.get(0));
        System.out.println("--------------------------------------");

        //перевіряємо чи є в колекції вказаний елемент
        System.out.println("Check if collection contains 'a' : " + test.contains("a"));
        System.out.println("--------------------------------------");

        //тест методу 'clear()'
        System.out.println("Collection size before 'clear' : " + test.size());
        test.clear();
        System.out.println("Collection size after 'clear' : " + test.size());
        System.out.println("--------------------------------------");

    }

}
