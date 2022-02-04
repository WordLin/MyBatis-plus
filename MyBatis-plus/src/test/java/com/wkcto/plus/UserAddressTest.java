package com.wkcto.plus;

import com.wkcto.entity.Address;
import com.wkcto.entity.Dept;
import com.wkcto.plus.dao.AddressMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SuppressWarnings("all")
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAddressTest {
    @Autowired
    private AddressMapper addressMapper;
    @Test
    public void testInsert(){
       Address address = new Address();
       address.setCity("成为人");
       address.setStreet("成熟街");
       address.setZipcode("102190");
        int insert = addressMapper.insert(address);
        System.out.println("insert = " + insert);
    }

}
