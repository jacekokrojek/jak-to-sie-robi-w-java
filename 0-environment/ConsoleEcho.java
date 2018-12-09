import java.util.Scanner;
/**
 * Sample Java programs that echoes user entry to the console
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/module-summary.html
 */
 public class ConsoleEcho {
    public static void main(String[] args) {		
        System.out.print("Enter the text: ");
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println("Echo: " + s);
    }
}
