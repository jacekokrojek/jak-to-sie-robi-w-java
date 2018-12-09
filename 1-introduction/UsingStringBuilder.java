import java.util.*;

public class UsingStringBuilder {

    public static Random rand = new Random(47);

    public static void main(String[] args) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < 25; i++) {
            result.append(rand.nextInt(100));
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        System.out.println(result.toString());
    }
}