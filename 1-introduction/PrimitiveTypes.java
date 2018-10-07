public class PrimitiveTypes {

    public static void main(String[] args) {
        /* Boolean literal */
        boolean result = true;

        /* Integer Literals
        * byte:     -128 .. 127
        * short:    -32,768 .. 32,767
        * int:      -2,147,483,648 .. 2,147,483,647
        * long:     -9,223,372,036,854,775,808 .. 9,223,372,036,854,775,807
        * */
        byte b = 100;
        short s = 10000;
        int decVal = 26;        // The number 26, in decimal
        int hexVal = 0x1a;      // The number 26, in hexadecimal
        int binVal = 0b11010;   // The number 26, in binary
        long bigNumber = 10000000L;

        /* Floating-Point Literals
        * float:    3.40282347 x 10^38, 1.40239846 x 10^-45
        * double:   1.7976931348623157 x 10^308, 4.9406564584124654 x 10^-324
         * */
        double d1 = 123.4;
        double d2 = 1.234e2;    // same value as d1, but in scientific notation
        float f1 = 123.4f;

        /* Character and String Literals */
        char capitalC = 'C';
        char capitalCAccent = '\u0108';
        String text = "Sample text \n\r";

        /* Underscore Characters in Numeric Literals  */
        long creditCardNumber = 1234_5678_9012_3456L;
        long socialSecurityNumber = 999_99_9999L;
        float pi = 3.14_15F;
        long hexBytes = 0xFF_EC_DE_5E;
        long hexWords = 0xCAFE_BABE;
        long maxLong = 0x7fff_ffff_ffff_ffffL;
        byte nybbles = 0b0010_0101;
        long bytes = 0b11010010_01101001_10010100_10010010;
		
    }
}
