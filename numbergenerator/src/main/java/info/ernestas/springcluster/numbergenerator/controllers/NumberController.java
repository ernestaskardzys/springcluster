package info.ernestas.springcluster.numbergenerator.controllers;

import info.ernestas.springcluster.numbergenerator.models.NumberResource;
import info.ernestas.springcluster.numbergenerator.services.NumberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumberController.class);

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @RequestMapping("/number")
    public NumberResource getNumber() {
        final long number = numberService.getNumber();
        LOGGER.info("Generated max number: " + number);

        return new NumberResource(number);
    }

}
