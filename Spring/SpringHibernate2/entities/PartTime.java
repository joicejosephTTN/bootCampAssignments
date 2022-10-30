package com.example.SpringHibernate.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
// not needed in case of TABLE_PER_CLASS,JOINED
//@DiscriminatorValue("Part-Time")
@PrimaryKeyJoinColumn(name="id")
public class PartTime extends Developer {
    private int hourlyRate;

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "PartTime{" +
                super.toString() +
                ", hourlyRate='" + hourlyRate + '\'' +
                '}';
    }
}
