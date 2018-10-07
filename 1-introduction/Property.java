import java.util.*;

public class Property {
    /** Sole entry point to class & application
     * @param args Array of string arguments
     * @return No return value
     */
    public static void main(String args[]) {
        System.out.println("--- Date:");
        System.out.println(new Date());
        System.getProperties().list(System.out);
        System.out.println("--- Memory Usage:");
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total Memory = "
                + rt.totalMemory()
                + " Free Memory = "
                + rt.freeMemory());
        System.out.println("Random value: " + Math.random());
    }
} 