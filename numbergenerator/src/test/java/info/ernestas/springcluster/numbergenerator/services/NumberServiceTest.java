package info.ernestas.springcluster.numbergenerator.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class NumberServiceTest {

    private NumberService numberService;

    @Before
    public void setUp() {
        numberService = new NumberService();
    }

    @Test
    public void testGetNumber() {
        assertTrue(numberService.getNumber() > 0);
    }

}
