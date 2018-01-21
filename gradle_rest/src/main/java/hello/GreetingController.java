package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String greetingTemplate = "Hello, %s!";
    private final AtomicLong greetingCounter = new AtomicLong();
    private static final String farewellTemplate = "Farewell, %s!";
    private final AtomicLong farewellCounter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(greetingCounter.incrementAndGet(),
                            String.format(greetingTemplate, name));
    }
    @RequestMapping("/farewell")
    public Farewell Farewell(@RequestParam(value="name", defaultValue="World") String name) {
        return new Farewell(farewellCounter.incrementAndGet(),
                            String.format(farewellTemplate, name));
    }
}
