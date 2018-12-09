public class Aplikacja {

    public static Generator factory (String type) {
        Generator gen = null;
        if (type.equals("wzrost")) {
             gen = new Wzrost();
        } else if (type.equals("uzytkownik")) {
            gen = new User();
        } else if (type.equals("adres")) {
            gen = new Adres();
        } else {
            throw new IllegalArgumentException();
        }
        return gen;
    }

    public static void main(String[] args) {

        try {
            Generator[] dane = new Generator[args.length - 1];
            for (int i = 1; i < args.length; i++) {
                dane[i - 1] = factory(args[i]);
            }

            int num = Integer.parseInt(args[0]);
            for (int i = 0; i < num; i++) {
                System.out.println(getStringBuffer(dane));
            }
        } catch(Exception e){
            usage();
        }
    }

    private static String getStringBuffer(Generator[] dane) {
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j < dane.length; j++) {
            sb.append(dane[j].generuj() + ";");
        }
        return sb.toString();
    }

    public static void usage(){
        System.out.println("Usage: java Aplikacja numRows dane...");
        System.out.println("dane = wzrost|adres|uzytkownik");
    }

    public static void usageDane(){
        System.out.println("Dane muszą być typu wzrost|adres|uzytkownik");
    }


}
