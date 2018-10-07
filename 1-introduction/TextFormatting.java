public class TextFormatting {

    /**
     * Format specifier syntax for character, and numeric types
     * %[argument_index$][flags][width][.precision]conversion
     * taken from https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#format-java.lang.String-java.lang.Object...-
     */

    public static void main(String[] args) {
        //Default formatting
        String.format("|%s|", "Hello World"); // prints: "Hello World"

        //Specify Field Length
        String.format("|%30s|", "Hello World"); // prints: |                   Hello World|

        //Left Justify Text
        String.format("|%-30s|", "Hello World"); // prints: |Hello World |

        //Specify Maximum Number of Characters
        String.format("|%.5s|", "Hello World"); // prints: |Hello|

        //Field Width and Maximum Number of Characters
        String.format("|%30.5s|", "Hello World"); //prints | Hello|

    }

    public static void integerFormatting(){
        // Default formatting:
        String.format("%d", 93); // prints 93

        //Specifying a width:
        String.format("|%20d|", 93); // prints: |                  93|

        //Pad with zeros:
        String.format("|%020d|", 93); // prints: |00000000000000000093|

        //Use locale-specific thousands separator:
        String.format("|%,d|", 10000000); // prints: |10,000,000|

        //Octal output:
        String.format("|%o|", 93); // prints: 135
        String.format("|%#o|", 93); // prints: 0135

        //Hex output:
        String.format("|%x|", 93); // prints: 5d
        String.format("|%#x|", 93); // prints: 0x5d
        String.format("|%#X|", 93);
    }
}
