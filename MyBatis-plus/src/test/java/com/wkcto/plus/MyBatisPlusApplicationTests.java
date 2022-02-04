package com.wkcto.plus;

import com.wkcto.entity.User;
import com.wkcto.plus.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
class MyBatisPlusApplicationTests {
    @Autowired(required = false)
    private UserMapper userMapper;


    @Test
    public void testInsert(){
        for (int i = 0; i < 8; i++) {
            User user = new User();
            user.setName("lisi" + i);
            user.setEmail("lisi@sina.com");
            user.setAge(22 + i);
            userMapper.insert(user);
        }

    }


    @Test
    public void testUpdateById(){
        User user = new User();
        user.setName("wangwu");
        user.setEmail("wangwu@sina.com");
        user.setAge(22);
        user.setId(7);
        userMapper.updateById(user);

        Integer id = user.getId();
        System.out.println("id = " + id);
    }


    @Test
    public void testUpdateById3(){
        User user = new User();
        user.setAge(25);
        user.setId(7);
        userMapper.updateById(user);

        Integer id = user.getId();
        System.out.println("id = " + id);
    }


    @Test
    public void deleteById(){
        int i = userMapper.deleteById(6);
        System.out.println("i = " + i);
    }


    @Test
    public void deleteByMap(){
        Map<String,Object> map = new HashMap();
        map.put("id",7);
        map.put("name","wangwu");
        int i = userMapper.deleteByMap(map);

        System.out.println("i = " + i);
    }


    @Test
    public void deleteBatchIds(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int i = userMapper.deleteBatchIds(list);

        System.out.println("i = " + i);
    }

    @Test
    public void deleteBatchIds1(){
        //Lambda表达式 Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
        List<Integer> list = Stream.of(13,14,15,16,17,18,19,20,21).collect(Collectors.toList());
        int i = userMapper.deleteBatchIds(list);

        System.out.println("i = " + i);
    }

    @Test
    public void selectById(){
        User user = userMapper.selectById(15);
        if (user != null) {
            System.out.println("user = " + user);

        }
    }


    @Test
    public void TestSelectBatchIds(){
        List<Integer> list = new ArrayList();
        list.add(12);
        list.add(13);
        list.add(14);
        List<User> userList = userMapper.selectBatchIds(list);
        userList.forEach(user -> {
            System.out.println("user = " + user);
        });
    }


    @Test
    public void TestSelectBatchIds1(){
        List<Integer> list = Stream.of(22,23,24).collect(Collectors.toList());
        List<User> userList = userMapper.selectBatchIds(list);
        userList.forEach(user -> {
            System.out.println("user = " + user);
        });
    }


    @Test
    public void testSelectByMap(){
        Map<String,Object> map = new HashMap();
        map.put("name","lisi7");
        map.put("age",29);
        map.put("age",28);
        List<User> userList = userMapper.selectByMap(map);
        userList.forEach(user -> {
            System.out.println("user = " + user);
        });
    }

}
