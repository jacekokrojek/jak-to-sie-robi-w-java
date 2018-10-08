import java.util.Scanner;

/**
 * More information about reading from console can be found here
 */
public class ConsoleEcho {
    public static void main(String[] args) {
        System.out.print("Enter the text: ");
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println("Echo: " + s);
    }
}
