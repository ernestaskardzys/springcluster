package info.ernestas.springcluster.numbergenerator.services;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class NumberService {

    private static final int MAX_NUMBER = 10_000;

    public long getNumber() {
        return new SecureRandom().nextInt(MAX_NUMBER);
    }

}
