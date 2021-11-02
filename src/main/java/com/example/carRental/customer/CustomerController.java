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
    private final AtomicLong customerId = new AtomicLong();
    private Map<Long, Customer> customers = new HashMap<>();

    public CustomerController(){
        long id = customerId.incrementAndGet();
        customers.put(id, new Customer(id, "Phred", "Phlintstone"));

        id = customerId.incrementAndGet();
        customers.put(id, new Customer(id, "John", "Gillard"));

        id = customerId.incrementAndGet();
        customers.put(id, new Customer(id, "First", "Last"));
    }

    @GetMapping
    public String root(){
        return "customer root directory";
    }

    @GetMapping("/all")
    public List<Customer> all() {
        return new ArrayList<>(customers.values());
    }

    @GetMapping("/{id}")
    public Customer customer(@PathVariable long id) {
        return customers.get(id);
    }

    @PostMapping
    public Customer newCustomer(@RequestBody Customer newCustomer) {
        long id = customerId.incrementAndGet();

        newCustomer.setId(id);
        customers.put(id, newCustomer);

        return newCustomer;
    }

    @PutMapping("/{id}")
    public Customer updateCar(@PathVariable long id, @RequestBody Customer newCustomer){
        Customer thiscustomer = customers.get(id);

        if(thiscustomer == null)
            return thiscustomer;

        if(newCustomer.getFirstName() != null)
            thiscustomer.setFirstName(newCustomer.getFirstName());
        if(newCustomer.getLastName() != null)
            thiscustomer.setLastName(newCustomer.getLastName());

        return thiscustomer;
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id){
        customers.remove(id);
    }
}
