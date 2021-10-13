package task_1;

import java.util.*;

public class Test {

    public static void main(String[] args) {

        // MyArrayList tests

        MyList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.print();
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.isEmpty());

        myArrayList.add(5);
        myArrayList.add(7);
        myArrayList.add(3);
        myArrayList.print();
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.isEmpty());

        System.out.println(myArrayList.contains(7));
        System.out.println(myArrayList.contains(6));

        System.out.println(Arrays.toString(myArrayList.toArray()));
        for (int i = 0; i < 16; i++) {
            myArrayList.add(1);
        }
        myArrayList.print();
        System.out.println(myArrayList.size());

        myArrayList.remove(Integer.valueOf(7));
        myArrayList.print();
        System.out.println(myArrayList.size());

//        myArrayList.clear();
//        myArrayList.print();
//        System.out.println(myArrayList.size());

        System.out.println(myArrayList.set(5, 9));
        myArrayList.print();
        System.out.println(myArrayList.get(5));

        myArrayList.add(3, 7);
        myArrayList.print();
        System.out.println(myArrayList.size());

        System.out.println(myArrayList.remove(6));
        myArrayList.print();
        System.out.println(myArrayList.size());

        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(8);
        System.out.println(myArrayList.removeAll(set));
        myArrayList.print();
        System.out.println(myArrayList.size());

        Set<Integer> set1 = new HashSet<>();
        set1.add(3);
        set1.add(1);
        set1.add(8);
        System.out.println(myArrayList.containsAll(set1));

        myArrayList.addAll(set1);
        myArrayList.print();
        System.out.println(myArrayList.size());

        List<Integer> list = new ArrayList<>();
        list.add(555);
        list.add(666);
        list.add(777);
        myArrayList.addAll(2, list);
        myArrayList.print();
        System.out.println(myArrayList.size());

        // MyLinkedList tests

    }
}
