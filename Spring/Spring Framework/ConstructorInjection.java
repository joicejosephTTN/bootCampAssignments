package com.ttn.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/*
Dependency Injection can be performed in three different ways.
- Constructor based Dependency Injection
- Setter based Dependency Injection
- Field or Property-based Dependency Injection
*/

@Component
interface MovieFinder{
    void display();
}

@Component
class doesSomething implements MovieFinder{
    @Override
    public void display(){
        System.out.println("Something is happening, not sure what tho.");
    }
}
@Component
class SimpleMovieLister {

    // the SimpleMovieLister has a dependency on a MovieFinder


    private MovieFinder movieFinder;

    // a constructor so that the Spring container can 'inject' a MovieFinder
    // Spring will encounter our SimpleMovieLister class while doing a package scan, and
    // will initialize its instance by calling the @Autowired annotated constructor.
    @Autowired
    public SimpleMovieLister(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
        System.out.println("Constructor called.");
    }

    // business logic that actually 'uses' the injected MovieFinder is omitted...
}

@SpringBootApplication
public class ConstructorInjection {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConstructorInjection.class, args);
        SimpleMovieLister movie = context.getBean(SimpleMovieLister.class);
    }

}
