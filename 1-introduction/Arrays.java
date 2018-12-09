
public class Arrays {
    public static void main(String args[]) {
        int a1[] = {1, 2, 3, 4, 5};
        System.out.println("Initial values");
        for (int i = 0; i < a1.length; i++) {
            prt("a1[" + i + "] = " + a1[i]);
        }
    }

    static void prt(String s) {
        System.out.println(s);
    }
}