import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomIntFacadeTest {

    final int EXPECTED_FIRST_INT = -1157408321;
    final int SEED = 5;
    RandomIntFacade randomString;

    @Before
    public void setUp() {
        this.randomString = new RandomIntFacade(SEED);
    }

    @Test
    public void shouldGeneratedRandomValue() {
        assertEquals(EXPECTED_FIRST_INT, randomString.generate());
    }

    @Ignore("Test is ignored as a demonstration")
    public void canMultiplyTwoByTwo() {
        int answer = 4;
        assertEquals("2x2=4", 4, answer);
    }

}
