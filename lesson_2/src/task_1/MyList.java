package task_1;

import java.util.Collection;

public interface MyList<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Object[] toArray();

    boolean add(E e);

    boolean remove(Object o);

    boolean containsAll(Collection<?> c);

    boolean addAll(Collection<? extends E> c);

    boolean addAll(int index, Collection<? extends E> c);

    boolean removeAll(Collection<?> c);

    void clear();

    E get(int index);

    E set(int index, E element);

    void add(int index, E element);

    E remove(int index);

    void print();
}
