package com.csi.dao;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CustomerDaoImpl {

    @Autowired
    CustomerRepo customerRepoImpl;

    public Customer saveData(Customer customer)
    {

        log.info("*********Trying to saveData for Customer: "+customer.getCustName());
        return customerRepoImpl.save(customer);
    }


    public List<Customer> getAllData()
    {

        log.info("*********Size of Data: "+ customerRepoImpl.findAll().size());
        return customerRepoImpl.findAll();
    }

    public Customer updateData(Customer customer)
    {

        log.info("*********Trying to Update Data for Customer: "+customer.getCustName());
        return customerRepoImpl.save(customer);
    }

    public void deleteData(long custId)
    {

        log.info("*********Trying to Delete for Customer: "+custId);
        customerRepoImpl.deleteById(custId);
    }
}
