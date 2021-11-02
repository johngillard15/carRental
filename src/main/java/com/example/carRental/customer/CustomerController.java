package com.example.carRental.customer;

import com.example.carRental.car.Car;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/customer")
public class CustomerController {
//    private final AtomicLong customerId = new AtomicLong();
//    private Map<Long, Customer> customers = new HashMap<>();
//
//    public CustomerController(){
//        long id = customerId.incrementAndGet();
//        customers.put(id, new Customer(id, "Phred", "Phlintstone"));
//    }
//
//    @GetMapping
//    public String root(){
//        return "customer root directory";
//    }
//
//    @GetMapping("/all")
//    public List<Customer> all() {
//        return new ArrayList<>(customers.values());
//    }
//
//    @GetMapping("/{id}")
//    public Customer customer(@PathVariable long id) {
//        return customers.get(id);
//    }
//
//    @PostMapping
//    public Customer newCustomer(@RequestBody Customer newCustomer) {
//        long id = customerId.incrementAndGet();
//
//        newCustomer.setId(id);
//        customers.put(id, newCustomer);
//
//        return newCustomer;
//    }
//
//    @PutMapping("/{id}")
//    public Customer updateCar(@PathVariable long id, @RequestBody Customer newCustomer){
//        Customer thiscustomer = customers.get(id);
//
//        if(thiscustomer == null)
//            return thiscustomer;
//
//        if(newCar.getMake() != null)
//            thiscustomer.setMake(newCar.getMake());
//        if(newCar.getModel() != null)
//            thiscustomer.setModel(newCar.getModel());
//
//        return thiscustomer;
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteCar(@PathVariable long id){
//        cars.remove(id);
//    }
}
