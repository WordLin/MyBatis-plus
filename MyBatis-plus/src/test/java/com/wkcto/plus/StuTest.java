package com.wkcto.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wkcto.entity.Stu;
import com.wkcto.plus.dao.StuMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("all")
@RunWith(SpringRunner.class)
@SpringBootTest
public class StuTest {
    @Autowired
    private StuMapper stuMapper;

    @Test
    public void testInsert() {
        Stu stu = new Stu();
        stu.setAge(20);
        stu.setName("万人迷");
        stu.setEmail("wanrenmi@163.com");
        stu.setStatus(1);
        int i = stuMapper.insertStu(stu);
        System.out.println("i = " + i);

    }


    @Test
    public void testSelectStuById() {
        Stu stu = stuMapper.selectStuById(4);
        System.out.println("stu = " + stu);
    }

    @Test
    public void testSelectStuByName() {
        List<Stu> sList = stuMapper.selectStuByName("丽丽");
        sList.forEach(stu -> {
            System.out.println("stu = " + stu);
        });
    }

    @Test
    public void testAllEq() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        Map<String, Object> map = new HashMap();
        map.put("name", "张三");
        map.put("age", 22);
        qw.allEq(map);
        List<Stu> sList = stuMapper.selectList(qw);
        sList.forEach(stu -> {
            System.out.println("stu = " + stu);
        });
    }

    @Test
    public void testAllEq1() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        Map<String, Object> map = new HashMap();
        map.put("name", "张三");

        map.put("age", null);
        //后面的那个Boolean类型是判断是否处理null值，如上有null为true的话就得将其带入带sql语句中
        qw.allEq(map, false);
        List<Stu> sList = stuMapper.selectList(qw);
        sList.forEach(stu -> {
            System.out.println("stu = " + stu);
        });
    }

    @Test
    public void testEq() {
        QueryWrapper<Stu> qw = new QueryWrapper<>();
        qw.eq("name", "李雷");
        List<Stu> stus = stuMapper.selectList(qw);
        stus.forEach(stu -> {
            System.out.println("stu = " + stu);
        });
    }

    @Test
    public void testNe() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.ne("name", "张三");
        List<Stu> stus = stuMapper.selectList(qw);
        stus.forEach(stu -> {
            System.out.println("stu = " + stu);
        });
    }

    @Test
    public void testGt() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.gt("age", 20);
        List<Stu> stus = stuMapper.selectList(qw);
        stus.forEach(stu -> {
            System.out.println("stu = " + stu);
        });
    }

    @Test
    public void testGe() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.ge("age", 20);
        List<Stu> stus = stuMapper.selectList(qw);
        stus.forEach(stu -> {
            System.out.println("stu = " + stu);
        });
    }

    @Test
    public void testLt() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.lt("age", 20);
        List<Stu> stus = stuMapper.selectList(qw);
        stus.forEach(stu -> {
            System.out.println("stu = " + stu);
        });
    }

    @Test
    public void testLe() {
        QueryWrapper<Stu> qw = new QueryWrapper<>();
        qw.le("age", 20);
        for (Stu stu : stuMapper.selectList(qw)) {
            System.out.println("stu = " + stu);
        }
    }

    @Test
    public void testBetween() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.between("age", 20, 25);
        for (Stu stu : stuMapper.selectList(qw)) {
            System.out.println("stu = " + stu);
        }
    }

    @Test
    public void testNotBetween() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.notBetween("age", 20, 30);
        List<Stu> stus = stuMapper.selectList(qw);
        stus.forEach(stu -> {
            System.out.println("stu = " + stu);
        });
    }

    @Test
    public void testLike() {
        QueryWrapper<Stu> qw = new QueryWrapper<>();
        qw.like("name", "丽");
        List<Stu> stus = stuMapper.selectList(qw);
        for (Stu stu : stus) {
            System.out.println("stu = " + stu);
        }
    }

    @Test
    public void testNotLike() {
        QueryWrapper<Stu> qw = new QueryWrapper<>();
        qw.notLike("name", "雷");
        List<Stu> stus = stuMapper.selectList(qw);
        stus.forEach(stu -> System.out.println("stu = " + stu));
    }

    @Test
    public void testLikeLeft() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.likeLeft("name", "三");
        List<Stu> stus = stuMapper.selectList(qw);

        stus.forEach(stu -> System.out.println("stu = " + stu));
    }

    @Test
    public void testLikeRight() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.likeRight("name", "李");
        for (Stu stu : stuMapper.selectList(qw)) {
            System.out.println("stu = " + stu);
        }
    }

    @Test
    public void testIsNull() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.isNull("email");
        for (Stu stu : stuMapper.selectList(qw)) {
            System.out.println("stu = " + stu);
        }
    }

    @Test
    public void testIsNotNull() {
        QueryWrapper<Stu> qw = new QueryWrapper<>();
        qw.isNotNull("email");
        for (Stu stu : stuMapper.selectList(qw)) {
            System.out.println("stu = " + stu);
        }
    }

    @Test
    public void testIn() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.in("age", 20, 24, 28);
        for (Stu stu : stuMapper.selectList(qw)) {
            System.out.println("stu = " + stu);
        }

    }

    @Test
    public void testNotIn() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.notIn("age", 18, 19);
        for (Stu stu : stuMapper.selectList(qw)) {
            System.out.println("stu = " + stu);
        }
    }

    @Test
    public void testIn1() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        List<Integer> list = Stream.of(20, 21, 22, 23, 24, 25).collect(Collectors.toList());
        qw.in("age", list);
        for (Stu stu : stuMapper.selectList(qw)) {
            System.out.println("stu = " + stu);
        }
    }

    @Test
    public void testInSql() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.inSql("age", "select age from stu where age < 30");
        print(qw);
    }

    @Test
    public void testNotInSql() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.notInSql("age", "select age from stu where age <> 18");
        print(qw);
    }

    @Test
    public void testGroupBy() {
        QueryWrapper<Stu> qw = new QueryWrapper<>();
        qw.select("name,count(*) personNumbers");
        qw.groupBy("name");
        print(qw);
    }

    @Test
    public void testOrderByAsc() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.orderByAsc("age");
        print(qw);
    }

    @Test
    public void testOrderByDesc() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.orderByDesc("age", "name");
        print(qw);
    }

    @Test
    public void testOrder() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.orderBy(true, true, "age");
        print(qw);
    }

    @Test
    public void testOrderBy() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.orderBy(false, true, "age");
        print(qw);
    }

    @Test
    public void testOrderBy1() {
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.orderBy(true, true, "age").orderBy(true, true, "name").orderBy(true, true, "id");
        print(qw);

    }

    @Test
    public void testOr(){
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.eq("name","张三")
                .or()
                .ge("age",20);
        print(qw);
    }

    @Test
    public void testLast(){
        QueryWrapper<Stu> qw = new QueryWrapper();
        qw.eq("name","李四")
                .or()
                .le("age",28)
                        .last("limit 2");
        print(qw);
    }

    @Test
    public void testExists(){
        QueryWrapper<Stu> qw = new QueryWrapper();
//        qw.exists("select id from stu where age<18");
        qw.notExists("select id from stu where age > 40");
        print(qw);
    }

    public void print(QueryWrapper<Stu> qw) {
        List<Stu> list = stuMapper.selectList(qw);
        list.forEach(stu -> System.out.println("stu = " + stu));
    }

    @Test
    public void testPagiNationInnerInterceptor(){
        QueryWrapper<Stu> qw = new QueryWrapper<>();
        qw.le("age",29);
        IPage<Stu> page = new Page<>();
        page.setCurrent(2);
        page.setSize(3);
        IPage<Stu> oo = stuMapper.selectPage(page, qw);

        List<Stu> sList = oo.getRecords();
        sList.forEach(stu -> System.out.println("stu = " + stu));
        System.out.println("sList的size = " + sList.size());

        System.out.println("页数 ="+oo.getPages());
        System.out.println("记录数 = "+oo.getTotal());
        System.out.println("当前页 = "+ oo.getCurrent());
        System.out.println("每页记录数 = "+oo.getSize());
    }

    //
    @Test
    public void getPath(){
        String path = System.getProperty("user.dir");
        System.out.println("path = " + path);
    }
}
