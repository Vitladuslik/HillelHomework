package HW10.Iterator;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionRun {

    public static void main(String[] args) {

        //стартовий масив
        String[] arr = new String[]{"1", "2", "3", "4", "5", "6"};

        //об'єкт класу сервісу

        CollectionImpl service = new CollectionImpl(arr);

        service.add("9");
        service.add(6, "7");


        System.out.println("Array we have : " + service);

        System.out.println("--------------------------------------");

        System.out.println("Iteration begins");
        List<String> list = new ArrayList<>(List.of(arr));
        Iterator<String> iterator = service.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }




    }

}
