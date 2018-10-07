package b.klasy;

// Demonstration of both constructor
// and ordinary method overloading.
import java.util.*;
class Tree {
    int height;
    Tree() {
        prt("Planting a seedling");
        height = 0;
    }
    Tree(int i) {
        prt("Creating new Tree that is "
                + i + " feet tall");
        height = i;
    }
    void info() {
        prt("Tree is " + height
                + " feet tall");
    }
    void info(String s) {
        prt(s + ": Tree is "
                + height + " feet tall");
    }
    static void prt(String s) {
        System.out.println(s);
    }
}
public class Overloading {
    static Random rand = new Random();
    static int pRand(int mod) {
        return Math.abs(rand.nextInt()) % mod;
    }
    public static void main(String args[]) {
        int i = 0;
        while(i != 9) {
            Tree t = new Tree(i = pRand(10));
            t.info();
            t.info("overloaded method");
        }
        // Overloaded constructor:
        new Tree();
    }
}