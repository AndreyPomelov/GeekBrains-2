package task_1;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E> implements MyList<E> {

    private E[] elements;
    private int size;

    public MyArrayList() {
        elements = (E[]) new Object[16];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        System.arraycopy(elements, 0, array, 0, array.length);
        return array;
    }

    @Override
    public boolean add(E o) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = o;
        return true;
    }

    private void resize() {
        E[] newArray = (E[]) new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                deleteAndMoveLeft(i);
                size--;
                return true;
            }
        }
        return false;
    }

    private void deleteAndMoveLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i+1];
        }
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[16];
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Запрашиваемый индекс (%s) выходит за пределы размеров коллекции " +
                            "(наибольший индекс - %s)", index, size - 1
            ));
        }
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Запрашиваемый индекс (%s) выходит за пределы размеров коллекции " +
                            "(наибольший индекс - %s)", index, size - 1
            ));
        }
        E returnElement = elements[index];
        elements[index] = element;
        return returnElement;
    }

    @Override
    public void add(int index, E element) {
        if (size == elements.length) {
            resize();
        }
        moveRight(index);
        elements[index] = element;
        size++;
    }

    private void moveRight(int index) {
        if (size - index >= 0) {
            System.arraycopy(elements, index, elements, index + 1, size - index);
        }
    }

    @Override
    public E remove(int index) {
        E element = elements[index];
        deleteAndMoveLeft(index);
        size--;
        return element;
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(toArray()));
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = true;
        for (Object element : c) {
            if (!remove(element)) {
                result = false;
            }
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E element : c) {
            add(index, element);
            index++;
        }
        return true;
    }
}
