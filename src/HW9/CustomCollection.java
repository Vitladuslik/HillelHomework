package HW9;

import java.util.Collection;

public interface CustomCollection<String> {

    boolean add(String str);

    boolean addAll(Collection strColl);

    boolean delete (int index);

    boolean delete (String str);

    String get(int index);

    boolean contains(String str);

    boolean clear();

    int size();

    boolean trim();

}
