package HW9;

import java.util.Collection;


public class CustomCollectionImpl implements CustomCollection <String> {

    transient int size = 0;

    transient Node<Object> first;

    transient Node<Object> last;

    public CustomCollectionImpl() {
    }

    @Override
    public boolean addAll(Collection <String> strColl) {
        return addAll(size, strColl);
    }

    @Override
    public boolean add(String str) {
        linkLast(str);
        return true;
    }

    @Override
    public boolean delete(int index) {
        checkElementIndex(index);
        unlink(node(index));
        return true;
    }

    @Override
    public boolean delete(String str) {
        if (str == null) {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (str.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public String get(int index) {
        checkElementIndex(index);
        return (String) node(index).item;
    }

    @Override
    public boolean contains(String str) {
        return indexOf(str) >= 0;
    }


    @Override
    public boolean clear() {
        for (Node<Object> x = first; x != null; ) {
            Node<Object> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean trim() {
        return true;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<Object> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    void linkLast(Object e) {
        final Node<Object> l = last;
        final Node<Object> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    Object unlink(Node<Object> x) {

        final Object element = x.item;
        final Node<Object> next = x.next;
        final Node<Object> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private boolean addAll(int index, Collection<String> c) {
        checkPositionIndex(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        Node<Object> pred;
        Node<Object> succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }

        for (Object o : a) {
            Node<Object> newNode = new Node<>(pred, o, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }

        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }

        size += numNew;
        return true;
    }

    private static class Node<Object> {
        Object item;
        Node<Object> next;
        Node<Object> prev;

        Node(Node<Object> prev, Object element, Node<Object> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index))
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    Node<Object> node(int index) {

        Node<Object> x;
        if (index < (size >> 1)) {
            x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }

    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<Object> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

}
