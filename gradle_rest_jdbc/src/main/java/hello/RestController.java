package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;



@RestController
public class myRestController {
  
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    // @RequestMapping("/greeting")
    // public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    //     return new Greeting(counter.incrementAndGet(),
    //                         String.format(template, name));
    // }

    @RequestMapping("/getUser")
    public Result myResult(@RequestParam(value="name", defaultValue="World") String name) {
      log.info("Querying for customer records where first_name = " + name);
      String sqlQuery = "SELECT id, first_name, last_name FROM customers WHERE first_name = ?";
      jdbcTemplate.query(sqlQuery, new Object[] { name },
      (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
).forEach(customer -> log.info(customer.toString()));

        return new Result(counter.incrementAndGet(),
                            customer.toString());


    }

}
