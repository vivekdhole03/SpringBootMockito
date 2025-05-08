package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import com.csi.service.CustomerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @Autowired
    CustomerRepo customerRepoImpl;

    @PostMapping("/savedata")
    public ResponseEntity<Customer> saveData(@RequestBody Customer customer)
    {

        //Hello World
        log.info("Trying to save data: "+customer.getCustName());
        return  ResponseEntity.ok(customerServiceImpl.saveData(customer));
    }

    @GetMapping("/getdata")
    public List<Customer> getAllData()
    {
        return customerServiceImpl.getAllData();
    }

    @PutMapping("/updatedata/{custId}")
    public Customer updateData(@PathVariable long custId, @RequestBody Customer customer) throws RecordNotFoundException {
        //

        Customer customer1= customerRepoImpl.findById(custId).orElseThrow(()->new RecordNotFoundException("Customer Record npot found"));

        customer1.setCustName(customer.getCustName());
        customer1.setCustAddress(customer.getCustAddress());
        customer1.setCustContactNumber(customer.getCustContactNumber());
        return customerServiceImpl.updateData(customer1);
    }

    @DeleteMapping("/deletedata/{custId}")
    public String deleteData(@PathVariable long custId)
    {
        customerServiceImpl.deleteData(custId);
        return "Data Deleted Successfully";
    }
}
