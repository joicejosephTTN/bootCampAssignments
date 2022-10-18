package com.ttn.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
interface Food
{
    public void info();
}

@Component
class Restaurant
{

    @Autowired
    Food food;

    public void setFood(Food food)
    {
        this.food = food;
    }

    public void eatFood() {
        System.out.println("eating food");
        food.info();
    }

}
@Component

class Italian implements Food{
    @Override
    public void info(){
        System.out.println("from Mario's pizzeria.");
    }
}


//@Primary indicates that a bean should be given preference when multiple candidates
// are qualified to autowire a single-valued dependency.

@Component
@Primary
class Chinese implements Food{
    @Override
    public void info(){
        System.out.println("from Hong's kitchen.");
    }
}

@SpringBootApplication
public class AmbiguityResolution {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AmbiguityResolution.class,args);
        Restaurant resto = applicationContext.getBean(Restaurant.class);
        resto.eatFood();
    }
}
