package generator;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PeselTest {

    final long EXPECTED_FIRST_INT = 2157408321l;
    final int SEED = 5;
    final String EXPECTED_CHECKSUM = "1";
    Pesel pesel;

    @Before
    public void setUp() {
        this.pesel = new Pesel(SEED);
    }

    @Test
    public void shouldGeneratedRandomValue() {
        assertEquals(EXPECTED_FIRST_INT, pesel.generate());
    }

    @Test
    public void shouldGeneratedCorrectChecksum() {
        assertEquals(EXPECTED_CHECKSUM, pesel.checksum("7905210801"));
    }

    @Ignore("Test is ignored as a demonstration")
    public void canMultiplyTwoByTwo() {
        int answer = 4;
        assertEquals("2x2=4", 4, answer);
    }

}
