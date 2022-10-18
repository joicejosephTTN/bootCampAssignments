package com.ttn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
class Student{
    public int studentId = 1;
    public String name = "Joice Joseph";
    public String subject = "Computer Science";


}

@SpringBootApplication
public class ApplicationContextProperties {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ApplicationContextProperties.class, args);
        Student student = context.getBean(Student.class);

        System.out.println(student.studentId);
        System.out.println(student.name);
        System.out.println(student.subject);
    }

}
