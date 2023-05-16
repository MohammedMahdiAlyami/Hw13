package com.example.hw13_q2.Controller;

import com.example.hw13_q2.Model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/Bankcontroller")
public class BankController {

    ArrayList<Customer> customers=new ArrayList<>();

    //read
    @GetMapping("/get")
    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    //create - Post
    @PostMapping("/add")
    public String addCustomer(@RequestBody Customer todo){
        customers.add(todo);
        return "customers added!";
    }

    //update - Put
    @PutMapping("/update/{index}")
    public String updateCustomer(@PathVariable int index ,@RequestBody Customer todo){
        customers.set(index, todo);
        return "customers updated!";
    }

    //delete
    @DeleteMapping("/delete/{index}")
    public String deleteCustomer(@PathVariable int index){
        customers.remove(index);
        return "customers deleted!";
    }

    //deposit
    @PutMapping("/deposit/{index}")
    public String updateCustomerDeposit(@PathVariable int index ,@RequestBody Account account){

        Customer customer = customers.get(index);
        customer.setBalance(customer.getBalance() + account.getDeposit());

        customers.set(index, customer);
        return "customers updated!";
    }

    //withdraw
    @PutMapping("/withdraw/{index}")
    public String updateCustomerWithdraw(@PathVariable int index ,@RequestBody Account account){

        Customer customer = customers.get(index);
        customer.setBalance(customer.getBalance() - account.getWithdraw());

        customers.set(index, customer);
        return "customers updated!";
    }

}
