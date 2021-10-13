package task_1;

import java.util.Collection;

public class MyLinkedList<E> implements MyList<E> {

    private Element<E> first;
    private Element<E> last;
    private int size;

    public MyLinkedList() {
        size = 0;
    }

    @Override
    public void print() {
        for (Element<E> element = first; element != null; element = element.next) {
            System.out.print(element.content + "   ");
        }
        System.out.printf(
                "\nSize = %s, first - %s, last - %s%n",
                size,
                first == null ? null : first.content,
                last == null ? null : last.content);
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
        for (Element<E> element = first; element != null; element = element.next) {
            if (element.content.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int index = 0;
        for (Element<E> element = first; element != null; element = element.next) {
            result[index++] = element.content;
        }
        return result;
    }

    @Override
    public boolean add(E o) {
        Element<E> newElement = new Element<>(o, last, null);
        if (last != null) {
            last.next = newElement;
        } else {
            first = newElement;
        }
        last = newElement;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (Element<E> element = first; element != null; element = element.next) {
            if (element.content.equals(o)) {
                element.previous.next = element.next;
                element.next.previous = element.previous;
                size--;
                return true;
            }
        }
        return false;
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
            add(index++, element);
        }
        return true;
    }

    @Override
    public void clear() {
        first = last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index < size / 2) {
            int iter = 0;
            for (Element<E> element = first; element != null; element = element.next) {
                if (iter++ == index) {
                    return element.content;
                }
            }
        } else {
            int iter = size - 1;
            for (Element<E> element = last; element != null; element = element.previous) {
                if (iter-- == index) {
                    return element.content;
                }
            }
        }
        return null;
    }

    @Override
    public E set(int index, E o) {
        E returnElement = null;
        if (index < size / 2) {
            int iter = 0;
            for (Element<E> element = first; element != null; element = element.next) {
                if (iter++ == index) {
                    returnElement = element.content;
                    element.content = o;
                }
            }
        } else {
            int iter = size - 1;
            for (Element<E> element = last; element != null; element = element.previous) {
                if (iter-- == index) {
                    returnElement = element.content;
                    element.content = o;
                }
            }
        }
        return returnElement;
    }

    @Override
    public void add(int index, E o) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(String.format(
                    "Запрашиваемый индекс (%s) выходит за пределы размеров коллекции " +
                            "(наибольший индекс - %s)", index, size - 1
            ));
        }
        if (index < size / 2) {
            int iter = 0;
            for (Element<E> element = first; element != null; element = element.next) {
                if (iter++ == index) {
                    addByIndex(o, element);
                    break;
                }
            }
        } else {
            int iter = size - 1;
            for (Element<E> element = last; element != null; element = element.previous) {
                if (iter-- == index) {
                    addByIndex(o, element);
                    break;
                }
            }
        }
    }

    private void addByIndex(E o, Element<E> element) {
        Element<E> newElement = new Element<>(o, element.previous, element);
        if (element.previous != null) {
            element.previous.next = newElement;
        } else {
            first = newElement;
        }
        element.previous = newElement;
        size++;
    }

    @Override
    public E remove(int index) {
        E returnElement = null;
        if (index < size / 2) {
            int iter = 0;
            for (Element<E> element = first; element != null; element = element.next) {
                if (iter++ == index) {
                    returnElement = element.content;
                    removeById(element);
                }
            }
        } else {
            int iter = size - 1;
            for (Element<E> element = last; element != null; element = element.previous) {
                if (iter-- == index) {
                    returnElement = element.content;
                    removeById(element);
                }
            }
        }
        return returnElement;
    }

    private void removeById(Element<E> element) {
        element.previous.next = element.next;
        element.next.previous = element.previous;
        size--;
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

    private static class Element<E> {

        E content;
        Element<E> previous;
        Element<E> next;

        Element(E content, Element<E> previous, Element<E> next) {
            this.content = content;
            this.previous = previous;
            this.next = next;
        }
    }
}
