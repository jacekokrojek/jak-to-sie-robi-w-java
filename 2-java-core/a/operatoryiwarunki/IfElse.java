package a.operatoryiwarunki;

public class IfElse {
    static final int TARGET = 0;
    static int test(int testval) {
        int result = 0;
        if(testval > TARGET)
            result = -1;
        else if(testval < TARGET)
            result = +1;
        else
            result = 0; // match
        return result;
    }

    static int test2(int testval) {
        if(testval > TARGET)
            return -1;
        if(testval < TARGET)
            return +1;
        return 0; // match
    }
}
