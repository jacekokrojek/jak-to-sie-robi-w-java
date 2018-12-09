import java.util.Random;

public class Generator {

    Random rand;

    public Generator(){
        rand = new Random();
    }

    public Generator(long seed){
        rand = new Random(seed);
    }

    public String generuj(){
        return "Przykładowa wartość";
    }

}
