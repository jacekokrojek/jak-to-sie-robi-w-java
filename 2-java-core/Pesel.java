public class Pesel {

    public static void main(String[] args){
        System.out.print(new Pesel().generate(1,1, 2000, 1, 1));
    }

    public String generate(int day, int month, int year, int gender, int index ){
        return "" + day + month + year + gender + index;
    }
}
