package generator;

import java.util.Random;

public class Pesel {

    Random random;

    public static void main(String[] args){
        Pesel pesel = new Pesel();
        String base = "" + pesel.generate();
        System.out.print(base + Pesel.checksum(base));
    }

    public Pesel(){
        this.random = new Random();
    }

    public Pesel(int seed){
        this.random = new Random(seed);
    }

    public long generate(){
        long base = 1000000000;
        return (base + Math.abs(this.random.nextInt()) )% (base *10);
    }

    public static String checksum(String str){
        int edycja;
        int wynik = 0;
        int[] tab = new int[10];
        int[] wagi= {1,3,7,9,1,3,7,9,1,3};
        for (int i = 0; i <= 9; i++){
            edycja = Character.getNumericValue(str.charAt(i));
            tab[i] = edycja;
        }

        for(int x = 0; x < 10 ; x++){
            wynik += tab[x] * wagi[x];
        }

        wynik = wynik % 10;

        wynik = 10 - wynik;

        wynik = wynik % 10;
        str = Integer.toString(wynik);
        return(str);
    }

}
