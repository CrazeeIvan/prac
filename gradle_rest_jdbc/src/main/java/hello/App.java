package com.hello.test;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.hello.bean.Person;
import com.hello.services.PersonService;
import com.hello.configuration.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;




@SpringBootApplication
public class App implements CommandLineRunner {

      public static void main(String args[]) {
        SpringApplication.run(App.class, args);
      }
@Autowired
JdbcTemplate jdbcTemplate;
private static final Logger log = LoggerFactory.getLogger(App.class);

@Override
public void run(String... strings) throws Exception {

    log.info("Creating tables");

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
        // int deleteMe = 3;
        // personService.deletePerson(deleteMe);
        //
        // yashwant.setFirstName("Yashwant - Updated");
        // yashwant.setLastName("Chavan - Updated");
        // yashwant.setAge(40);
        //
        // System.out.println("Update person Id = 1");
        // int updateMe = 1;
        // personService.editPerson(yashwant, updateMe);
        //
        // System.out.println("Find person Id = 2");
        // Person person = personService.find(2);
        // System.out.println(person);

        System.out.println("Find All Again");
        persons = personService.findAll();
        for (Person p: persons) {
            System.out.println(p);
        }

        context.close();
    }

}
