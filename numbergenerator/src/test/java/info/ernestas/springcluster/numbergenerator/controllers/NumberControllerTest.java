package info.ernestas.springcluster.numbergenerator.controllers;

import info.ernestas.springcluster.numbergenerator.models.NumberResource;
import info.ernestas.springcluster.numbergenerator.services.NumberService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumberControllerTest {

    private static final long NUMBER = 1234L;

    private NumberController numberController;

    private NumberService numberService;

    @Before
    public void setUp() {
        numberService = mock(NumberService.class);
        numberController = new NumberController(numberService);
    }

    @Test
    public void testGetNumber() {
        when(numberService.getNumber()).thenReturn(NUMBER);

        NumberResource numberResource = numberController.getNumber();

        assertThat(numberResource.getNumber(), is(NUMBER));
    }
}
