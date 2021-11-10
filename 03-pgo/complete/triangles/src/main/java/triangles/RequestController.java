package triangles;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import static triangles.SierpinskiTriangle.getSierpinskiTriangle;

@Controller("/")
public class RequestController {

    @Get(uri="/triangle/{n}", produces=MediaType.TEXT_PLAIN)
    public String triangle(int n) {
        String tri = getSierpinskiTriangle(n);
        return tri;
    }

    /*
    @Get(uri="/ping", produces=MediaType.TEXT_PLAIN)
    public String ping() {
        final int[] primes = Sieve.findPrimes(100000);
        return "pong : " + primes[primes.length - 1];
    }
    */
}