package com.wkcto.plus;

import com.wkcto.entity.Customer;
import com.wkcto.plus.dao.CustomerMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SuppressWarnings("all")
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {
    @Autowired
    private CustomerMapper customerMapper;
    @Test
    public void testInsert(){
        Customer customer = new Customer();
        customer.setCustAge(22);
        customer.setCustEmail("zhangsan@123.com");
        customer.setCustName("zhangsan");
        int num = customerMapper.insert(customer);
        System.out.println("num = " + num);
    }
}
