package com.ttn.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


/*
The @Component annotation is added on the top of each Java class to configure it as a java bean to be wired with
another class in a Spring project. Doing so, will make Spring Framework treat this class as a java bean.
 */
@Component
interface Sport
{
    public void info();
}

@Component
class Basketball
{

    /*
    The @Autowired annotation is added on the top of an instance variable/property in a class which is injected
    into the bean i.e. dependency injection, after the bean is constructed.
    */
    @Autowired
    @Qualifier("indoor") // explicitly mentioning the bean
    Sport sport;

    public void setSport(Sport sport)
    {
        this.sport = sport;
    }

    public void playSport() {
        System.out.println("Playing Basketball");
        sport.info();
    }

}
@Component
@Qualifier("indoor")
class Indoor implements Sport{
    @Override
    public void info(){
        System.out.println("in an indoor court.");
    }
}

// Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
// or using @Qualifier to identify the bean that should be consumed
@Component
@Qualifier("outdoor")
class Outdoor implements Sport{
    @Override
    public void info(){
        System.out.println("in an outdoor court.");
    }
}

@SpringBootApplication
public class SpringLooseCoupling {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringLooseCoupling.class,args);
        Basketball basketball = applicationContext.getBean(Basketball.class);

        basketball.playSport();
        // if I have 2 beans of the same type, it'll cause ambiguity.
        // Use primary or qualifier
    }

}
