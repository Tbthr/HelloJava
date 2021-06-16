package programming.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

public class test1 {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
//         Object\TreeSet
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private static void updateList(List list) {
        list.remove(2);
    }
}
