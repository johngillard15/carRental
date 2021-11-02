package com.example.carRental.car;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/car")
public class CarController {
    private final AtomicLong vinNumber = new AtomicLong();
    private Map<Long, Car> cars = new HashMap<>();
    private Car car;

    public CarController(){
        long id = vinNumber.incrementAndGet();
        cars.put(id, new Car(id, "Ford", "Focus"));

        id = vinNumber.incrementAndGet();
        cars.put(id, new Car(id, "Ford", "F-150"));

        id = vinNumber.incrementAndGet();
        cars.put(id, new Car(id, "Volkswagen", "Golf"));

        id = vinNumber.incrementAndGet();
        cars.put(id, new Car(id, "Toyota", "Corolla"));
    }

    @GetMapping
    public String root(){
        return "car root directory";
    }

    @GetMapping("/all")
    public List<Car> all() {
        return new ArrayList<>(cars.values());
    }

    @GetMapping("/{id}")
    public Car car(@PathVariable long id) {
        return cars.get(id);
    }

    @PostMapping
    public Car newCar(@RequestBody Car newCar) {
        long id = vinNumber.incrementAndGet();

        newCar.setVin(id);
        cars.put(id, newCar);

        return newCar;
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable long id, @RequestBody Car newCar){
        Car thisCar = cars.get(id);

        if(thisCar == null)
            return thisCar;

        if(newCar.getMake() != null)
            thisCar.setMake(newCar.getMake());
        if(newCar.getModel() != null)
            thisCar.setModel(newCar.getModel());

        return thisCar;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id){
        cars.remove(id);
    }
}
