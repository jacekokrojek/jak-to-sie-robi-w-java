import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {

    @Test
    public void shouldGenerateCorrectUser(){
        User user = new User(5);
        assertEquals("Aleksandra Duda", user.generuj());
    }

    @Test
    public void shouldGenerateUserMatchingPattern(){
        User user = new User();
        assertTrue(user.generuj().matches("\\w+ \\w+"));
    }

}

