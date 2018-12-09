public class ArrayNew {

    public static void main(String args[]) {
        int a[];
        a = new int[20];
        prt("length of a = " + a.length);
        for (int i = 0; i < a.length; i++) {
            prt("a[" + i + "] = " + a[i]);
        }
    }

    static void prt(String s) {
        System.out.println(s);
    }

}