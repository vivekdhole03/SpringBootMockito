package com.csi.dao.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.csi.dao.CustomerDaoImpl;
import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerDaoImplTest {

    @Autowired
    CustomerDaoImpl customerDaoImpl;

    @MockBean
    CustomerRepo customerRepoImpl;

    @Test
    public void saveDataTest()
    {
        Customer customer = new Customer(121, "SHUBHAM", "INDIA", 45656767);

        customerDaoImpl.saveData(customer);

        verify(customerRepoImpl, times(1)).save(customer);
    }

    @Test
    public void getAllDataTest()
    {

        when(customerRepoImpl.findAll()).thenReturn(Stream.of(new Customer(122, "MAHESH", "PUNE", 67676778), new Customer(125, "BINU", "USA", 5656767)).collect(Collectors.toList()));

        Assert.assertEquals(2, customerDaoImpl.getAllData().size());
    }

    @Test
    public void updateDataTest()
    {
        Customer customer = new Customer(121, "SHUBHAM", "INDIA", 45656767);

        customerDaoImpl.updateData(customer);

        verify(customerRepoImpl, times(1)).save(customer);

    }

    @Test
    public void deleteDataTest()
    {

        Customer customer = new Customer(121, "SHUBHAM", "INDIA", 45656767);

        customerDaoImpl.deleteData(customer.getCustId());

        verify(customerRepoImpl, times(1)).deleteById(customer.getCustId());

    }


}
