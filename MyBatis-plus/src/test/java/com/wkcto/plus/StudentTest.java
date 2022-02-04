import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wkcto.order.entity.Stu;
import com.wkcto.order.mapper.StuMapper;
import com.wkcto.plus.MyBatisPlusApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
/*
* spring单元测试指定配置类的第二种方式。
问题到了这里并没有完，网上也有人说即使测试的package和代码package不一样，通过指定@SpringBootTest(classes = Service1Application.class)也可以。
* */
@SuppressWarnings("all")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyBatisPlusApplication.class)//这里MyBatisPlusApplication是启动类
public class StudentTest {
    @Autowired
    private StuMapper stuMapper;

    @Test
    public void testInsert() {
        Stu stu = new Stu();
        stu.setAge(20);
        stu.setName("万人迷");
        stu.setEmail("wanrenmi@163.com");
        stu.setStatus(1);
        int i = stuMapper.insert(stu);
        System.out.println("i = " + i);

    }

    @Test
    public void testSelectById(){
        Stu stu = stuMapper.selectById(2);
        System.out.println("stu = " + stu);

    }
    @Test
    public void testSelectById2(){
        QueryWrapper<Stu> qw = new QueryWrapper<>();
        qw.eq("name","周丽");
        Stu stu = stuMapper.selectOne(qw);
        System.out.println("stu = " + stu);

    }
}
