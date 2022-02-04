package com.wkcto.plus;

import com.wkcto.entity.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DeptARTest {

    @Test
    public void testInsert(){
        Dept dept = new Dept();
        dept.setName("成为人");
        dept.setMobile("+8688888888");
        dept.setManager(102);
        boolean insert = dept.insert();
        System.out.println("insert = " + insert);
    }
    /*
    @Test
    public void testInsert(){
        for (int i = 0; i < 8; i++) {

            Dept dept = new Dept();
            dept.setName("销售部"+1);
            dept.setMobile(i+"+86123456");
            dept.setManager(101);
            boolean insert = dept.insert();
        }
    }
 @Test
    public void testUpdate(){
        Dept dept = new Dept();
        dept.setId(1);
        dept.setName("营销部");
        dept.setMobile("+86123456");
        dept.setManager(102);
        boolean insert = dept.updateById();
        System.out.println("insert = " + insert);
    }

    @Test
    public void testUpdate1(){
        Dept dept = new Dept();
        dept.setId(1);
        dept.setName("营销部");
        dept.setMobile("+86123456");
        dept.setManager(102);
        boolean insert = dept.updateById();
        System.out.println("insert = " + insert);
    }
    @Test
    public void testUpdate2(){
        Dept dept = new Dept();
        dept.setId(2);
        dept.setMobile("+8688888888");
        boolean insert = dept.updateById();
        System.out.println("insert = " + insert);
    }



    @Test
    public void testDelete(){
        Dept dept = new Dept();
        boolean insert = dept.deleteById(1);
        System.out.println("insert = " + insert);
    }


    @Test
    public void testARUpdateById(){
        Dept dept = new Dept();
        dept.setName("市场部");
        dept.setManager(101);
        dept.setId(3);
        boolean insert = dept.updateById();
        System.out.println("insert = " + insert);
    }

    @Test
    public void testARSelectById(){
        Dept dept = new Dept();
        dept.setId(3);
        Dept insert = dept.selectById();
        System.out.println("insert = " + insert);
    }*/
}
