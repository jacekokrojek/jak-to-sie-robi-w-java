import java.time.LocalDate;
import java.time.Period;

public class LocalDateSamples {

    public static void main(String[] args){
        LocalDate localDate1 = LocalDate.now();
        System.out.println("Local date #1: " + localDate1);
        // data podawana jako liczby rok-miesiąc-dzień
        LocalDate localDate2 = LocalDate.of(2019, 5, 25);
        System.out.println("Local date #2: " + localDate2);
        // data podawana text w formacie ISO
        LocalDate localDate3 = LocalDate.parse("2019-06-13");
        System.out.println("Local date #3: " + localDate3);

        // okres pomiędzy dwiema datami
        Period period2 = Period.between(localDate2, localDate1);
        System.out.println("Okres pomiędzy datami #1 i  #2: " + period2);

        Period diff = Period.between(
                LocalDate.parse("2016-08-31").withDayOfMonth(1),
                LocalDate.parse("2014-11-30").withDayOfMonth(1));
        System.out.println("Okres pomiędzy początkami miesięcy: " + diff);

    }
}
