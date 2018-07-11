package info.ernestas.springcluster.web;

import info.ernestas.springcluster.web.resources.CounterResource;
import info.ernestas.springcluster.web.services.NumberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    private static final String MICROSERVICE_URL = "http://localhost:";
    private static final long RESULT = 1234L;

    @LocalServerPort
    private int servicePort;

    @Value("${local.management.port}")
    private int managementPort;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private NumberService numberService;

    @Test
    public void shouldReturnGeneratedNumber() {
        when(numberService.getNumber()).thenReturn(RESULT);

        ResponseEntity<CounterResource> entity = restTemplate.getForEntity(
                MICROSERVICE_URL + servicePort + "/count", CounterResource.class);

        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
        assertThat(entity.getBody().getId(), is(RESULT));
        assertThat(entity.getBody().getMessage(), is("Number " + RESULT));
    }

    @Test
    public void serviceShouldWork() {
        ResponseEntity<Map> entity = restTemplate.getForEntity(
                MICROSERVICE_URL + managementPort + "/actuator/info", Map.class);

        assertThat(entity.getStatusCode(), is(HttpStatus.OK));
    }

}
