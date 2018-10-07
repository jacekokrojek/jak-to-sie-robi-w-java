package g.wyjatki;

public class Application {

    public static void main(String[] args) {
        if(args.length == 0)
            throw new IllegalArgumentException();
        if(args[0] == null)
            throw new NullPointerException("Parameter");
        /**
         * Application code
         */
    }

}
