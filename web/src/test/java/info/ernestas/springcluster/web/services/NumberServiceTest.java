package info.ernestas.springcluster.web.services;

import info.ernestas.springcluster.web.resources.NumberResource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class NumberServiceTest {

    private static final String HTTP = "http://";
    private static final String NUMBER_CONTROLLER_URL = "localhost:8080";
    private static final long GENERATED_NUMBER = 1234L;

    private RestTemplate restTemplate;
    private NumberService numberService;

    @Before
    public void setUp() {
        restTemplate = mock(RestTemplate.class);
        numberService = new NumberService(restTemplate, NUMBER_CONTROLLER_URL);
    }

    @Test
    public void testGetNumber() {
        NumberResource numberResource = new NumberResource(GENERATED_NUMBER);
        when(restTemplate.getForObject(HTTP + NUMBER_CONTROLLER_URL + "/number", NumberResource.class)).thenReturn(numberResource);

        long result = numberService.getNumber();

        assertThat(result, is(GENERATED_NUMBER));
    }
}
