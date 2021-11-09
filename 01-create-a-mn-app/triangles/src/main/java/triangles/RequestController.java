package triangles;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.annotation.Counted;

@Controller("/")
public class RequestController {
    //@Timed(value = "method.ping", percentiles = { 0.5, 0.95, 0.99 }, description = "Read ping metric")

    @Get(uri="/triangle/{n}", produces=MediaType.TEXT_PLAIN)
    @Timed(value = "method.triangle", description = "Count triangle metric")
    public String triangle(int n) {
        String tri = SierpinskiTriangle.getSierpinskiTriangle(n);
        return tri;
    }

    @Get(uri="/ping", produces=MediaType.TEXT_PLAIN)
    @Timed(value = "method.ping", description = "Count triangle metric")
    public String ping() {
        final int[] primes = Sieve.findPrimes(100000);
        return "pong : " + primes[primes.length - 1];
    }
}