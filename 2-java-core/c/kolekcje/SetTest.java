package c.kolekcje;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SetTest     {


    public static void main(String... args){

        List l = new LinkedList<Integer>();
        l.add(new Integer(1));
        l.add(new Integer(2));
        l.add(new Integer(1));
        l.add(new Integer(2));
        l.add(new Integer(3));

        Set<Integer> s = new HashSet<Integer>(l);
        for (Integer i : s) {
            System.out.println(i);
        }

    }
}
