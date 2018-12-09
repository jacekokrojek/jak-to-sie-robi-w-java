import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PeselTest {

    @Test
    public void shouldGenerateCorrectPesel(){
        Pesel pesel = new Pesel(new int[]{ 7, 9, 0,5, 2, 1, 0 ,8, 0, 1});
        assertEquals("79052108011", pesel.generuj());
    }

    @Test
    public void shouldGeneratePeselFromDateIdGender(){
        Pesel pesel = new Pesel("19790521", "080", "1");
        assertEquals("79052108011", pesel.generuj());
    }
}
