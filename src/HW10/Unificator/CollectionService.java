package HW10.Unificator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionService {

    public static void main(String[] args) {

        Collection <Object> test = new ArrayList<>();
        test.add("a");
        test.add("b");
        test.add("a");
        test.add("b");
        test.add("a");
        test.add("b");
        test.add("c");
        test.add("d");
        System.out.println("Collection before : " + test);
        CollectionService service = new CollectionService();
        System.out.println("Collection after : " + service.remover(test));

    }

    public Collection<Object> remover(Collection<Object> collection) {
        Collection <Object> result;
        result = new HashSet<>(collection);
        return result;
    }

}
