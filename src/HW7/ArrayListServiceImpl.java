package HW7;

import static HW7.Main.arrList;

public class ArrayListServiceImpl implements ArrayListService {


    @Override
    public boolean add(int index, String value) {

        arrList.add(index, value);
        return true;

    }

    @Override
    public boolean add(String value) {

        arrList.add(value);
        return true;

    }

    @Override
    public boolean delete(int index) {

        arrList.remove(index);
        return true;

    }

    @Override
    public boolean delete(String value) {

        arrList.remove(value);
        return true;

    }

    @Override
    public String get(int index) {
        return arrList.get(index);
    }
}
