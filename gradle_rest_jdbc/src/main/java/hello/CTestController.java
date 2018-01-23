package com.hello.test;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hello.bean.Person;
import com.hello.services.PersonService;

@RestController
public class CTestController {

    private static final String greetingTemplate = "Hello, %s!";
    private final AtomicLong greetingCounter = new AtomicLong();
    private static final String farewellTemplate = "Farewell, %s!";
    private final AtomicLong farewellCounter = new AtomicLong();
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    PersonService personService = (PersonService) context.getBean("personService");

    @RequestMapping("/greeting")
    public CTest cTest(@RequestParam(value="name", defaultValue="World") String name) {
      return new CTest(greetingCounter.incrementAndGet(),
                            String.format(greetingTemplate, name));
    }
    @RequestMapping("/farewell")
    public Person person(@RequestParam(value="name", defaultValue="Ciaran") String name) {
      Person tmp = new Person((int)farewellCounter.incrementAndGet(), name, "second_name", 35);
      personService.addPerson(tmp);
      return tmp;
    }
}
