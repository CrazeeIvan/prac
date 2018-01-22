package com.hello.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.hello.bean.Person;
import com.hello.configuration.ApplicationConfig;
import com.hello.services.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;




@SpringBootApplication
public class App {

      public static void main(String args[]) {
        SpringApplication.run(App.class, args);
}
@Autowired
JdbcTemplate jdbcTemplate;

@Override
public void run(String... strings) throws Exception {

    log.info("Creating tables");

    jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
    jdbcTemplate.execute("CREATE TABLE customers(" +
            "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

    // Split up the array of whole names into an array of first/last names
    List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream()
            .map(name -> name.split(" "))
            .collect(Collectors.toList());

    // Use a Java 8 stream to print out each tuple of the list
    splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

    // Uses JdbcTemplate's batchUpdate operation to bulk load data
    jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

    log.info("Querying for customer records where first_name = 'Josh':");
    jdbcTemplate.query(
            "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", new Object[] { "Josh" },
            (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
    ).forEach(customer -> log.info(customer.toString()));


        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        PersonService personService = (PersonService) context.getBean("personService");

        Person yashwant = new Person(1, "Yashwant", "Chavan", 32);
        Person mahesh = new Person(2, "Mahesh", "Patil", 25);
        Person vishal = new Person(3, "Vishal", "Naik", 40);

        personService.addPerson(yashwant);
        personService.addPerson(mahesh);
        personService.addPerson(vishal);

        System.out.println("Find All");
        List < Person > persons = personService.findAll();
        for (Person person: persons) {
            System.out.println(person);
        }

        System.out.println("Delete person Id = 3");
        int deleteMe = 3;
        personService.deletePerson(deleteMe);

        yashwant.setFirstName("Yashwant - Updated");
        yashwant.setLastName("Chavan - Updated");
        yashwant.setAge(40);

        System.out.println("Update person Id = 1");
        int updateMe = 1;
        personService.editPerson(yashwant, updateMe);

        System.out.println("Find person Id = 2");
        Person person = personService.find(2);
        System.out.println(person);

        System.out.println("Find All Again");
        persons = personService.findAll();
        for (Person p: persons) {
            System.out.println(p);
        }

        context.close();
    }

}
