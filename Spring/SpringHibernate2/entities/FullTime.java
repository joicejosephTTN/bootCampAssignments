package com.example.SpringHibernate.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//not needed in case of TABLE_PER_CLASS,JOINED
//@DiscriminatorValue("Full-Time")
@PrimaryKeyJoinColumn(name="id")
public class FullTime extends Developer {
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FullTime{" +
                super.toString()+
                ", salary=" + salary +
                '}';
    }
}
