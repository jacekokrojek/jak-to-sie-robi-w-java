public class TextFormatting {

    /**
     * Format specifier syntax for character, and numeric types
     * %[argument_index$][flags][width][.precision]conversion
     * taken from https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#format-java.lang.String-java.lang.Object...-
     */

    public static void main(String[] args) {
        stringFormatting();
		floatFormatting();
        integerFormatting();
    }

    public static void stringFormatting(){
        
        //Default formatting
        System.out.println(String.format("*%s*", "Hello World"));

        //Specify Field Length
        System.out.println(String.format("*%30s*", "Hello World"));

        //Left Justify Text
        System.out.println(String.format("*%-30s*", "Hello World"));

    }

    public static void integerFormatting(){
        // Default formatting:
        System.out.println(String.format("%d", 93));

        //Specifying a width:
        System.out.println(String.format("*%20d*", 93));

        //Pad with zeros:
        System.out.println(String.format("*%020d*", 93));

        //Use locale-specific thousands separator:
        System.out.println(String.format("*%,d*", 10000000));

        //Octal output:
        System.out.println(String.format("*%o*", 93));
        System.out.println(String.format("*%#o*", 93));

        //Hex output:
        System.out.println(String.format("*%x*", 93));
        System.out.println(String.format("*%#x*", 93));
        System.out.println(String.format("*%#X*", 93));
    }
	
	public static void floatFormatting(){
        // Decimal digits:
        System.out.println(String.format("%.2f", 93.1234));
    }

}
