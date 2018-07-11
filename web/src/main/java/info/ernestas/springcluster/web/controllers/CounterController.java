package info.ernestas.springcluster.web.controllers;

import info.ernestas.springcluster.web.resources.CounterResource;
import info.ernestas.springcluster.web.services.NumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CounterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CounterController.class);

    private final NumberService numberService;

    public CounterController(NumberService numberService) {
        this.numberService = numberService;
    }

    @RequestMapping("/count")
    public CounterResource greeting(@RequestParam(value="message", defaultValue="Number") String message) {
        LOGGER.info("Got request with parameters: " + message);
        final long generatedNumber = numberService.getNumber();
        LOGGER.info("Generated number is: " + generatedNumber);
        return new CounterResource(generatedNumber, message + " " + generatedNumber);
    }

}
