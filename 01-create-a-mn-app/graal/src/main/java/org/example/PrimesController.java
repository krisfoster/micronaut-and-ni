package org.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

@Controller("/primes") 
public class PrimesController {

    public PrimesController() {
    }

    @Get("/random") 
    public int randomPrime() { 
        Sieve sieve = new Sieve();
        return conferenceService.randomConf();
    }

    @Get("/{upper}") 
    public int upperPrime(@PathVariable Integer number) { 
        return conferenceService.randomConf();
    }
}