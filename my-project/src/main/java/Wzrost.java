import java.util.Locale;

public class Wzrost extends Generator{

    double wzrost;

    public Wzrost(){
        super();
    }

    public Wzrost(long seed){
        super(seed);
    }

    @Override
    public String generuj(){
        this.wzrost = 1 + rand.nextDouble();
        return String.format(Locale.ROOT, "%.2f", this.wzrost);
    }
}
