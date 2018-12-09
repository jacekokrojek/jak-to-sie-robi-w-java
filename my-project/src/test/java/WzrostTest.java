import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WzrostTest {

    @Test
    public void shouldGenerateCorrectWzrost(){
        Wzrost wzrost = new Wzrost(5);
        assertEquals("1.73", wzrost.generuj());
    }

}

