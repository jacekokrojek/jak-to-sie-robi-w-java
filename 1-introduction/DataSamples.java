import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DataSamples {

    public static void main(String[] args){
        Date nowDate = new Date();
        System.out.println("Aktualna data w domyślnym formacie: " + nowDate);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MMM-dd hh:mm");
        System.out.println("Aktualna data w formacie [yyyy-MM-dd hh:mm] i domyślej lokalizacji: " + sdf1.format(nowDate));

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MMM-dd hh:mm", Locale.forLanguageTag("Pl-pl"));
        System.out.println("Aktualna data w formacie [yyyy-MM-dd hh:mm] i polskiej lokalizacji: " + sdf2.format(nowDate));

        try {
            String birthDateString = "2019.01.02";
            SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy.MM.dd");
            Date birthDate = sdf3.parse(birthDateString);
            System.out.println("Data pobrana ze zmiennej tekstowej: " + birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


}
