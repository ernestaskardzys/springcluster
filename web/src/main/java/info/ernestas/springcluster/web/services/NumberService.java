package info.ernestas.springcluster.web.services;

import info.ernestas.springcluster.web.resources.NumberResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NumberService {

    private static final String HTTP = "http://";

    private final RestTemplate restTemplate;

    private String numberGeneratorUrl;

    public NumberService(RestTemplate restTemplate, @Value("${numberGenerator.url}") String numberGeneratorUrl) {
        this.restTemplate = restTemplate;
        this.numberGeneratorUrl = numberGeneratorUrl;
    }

    public long getNumber() {
        NumberResource numberResource = restTemplate.getForObject(HTTP + numberGeneratorUrl + "/number", NumberResource.class);
        return numberResource.getNumber();
    }

}
