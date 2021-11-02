package com.example.carRental.car;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
    @Id @GeneratedValue private Long vin;
    private String make;
    private String model;

    public Car(){}

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public Car(Long vin, String make, String model) {
        this.vin = vin;
        this.make = make;
        this.model = model;
    }

    public long getVin() {
        return vin;
    }

    public void setVin(long vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
