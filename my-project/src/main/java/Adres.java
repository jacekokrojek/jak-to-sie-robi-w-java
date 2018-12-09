public class Adres extends Generator {

    String[] ulice = {"Zielona", "Czerwona", "Niebieska", "Biała"};
    String ulica;

    public Adres(){
        super();
    }

    public Adres(long seed){
        super(seed);
    }

    @Override
    public String generuj(){
        int ulicaIndex = rand.nextInt( this.ulice.length);
        ulica = ulice[ ulicaIndex];
        return ulica + " " + rand.nextInt(100);
    }

}
