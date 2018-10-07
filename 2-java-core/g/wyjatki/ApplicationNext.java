package g.wyjatki;

public class ApplicationNext {

    public static void main(String[] args) {
        try {
            if (args.length == 0)
                throw new IllegalArgumentException();
            if (args[0] == null)
                throw new NullPointerException("Parameter");
        } catch (RuntimeException ex) {
            printUsage();
        }
        System.out.print("Generating " + args[0] + " sample records");
    }

    public static void printUsage() {
        System.out.print("Usage: java ApplicationNext numOfRecords");
    }
}
