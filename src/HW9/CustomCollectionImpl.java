package HW9;

import java.util.Collection;

public class CustomCollectionImpl implements CustomCollection{
    @Override
    public boolean add(Object str) {
        return false;
    }

    @Override
    public boolean addAll(Collection strColl) {
        return false;
    }

    @Override
    public boolean delete(int index) {
        return false;
    }

    @Override
    public boolean delete(Object str) {
        return false;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public boolean contains(Object str) {
        return false;
    }

    @Override
    public boolean clear() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean trim() {
        return false;
    }
}
