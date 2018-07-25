import com.huaqin.domain.User;
import com.huaqin.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {


    /*@Test
    public void testFindAll() throws Exception {
        // 加载主配置文件，目的是构建SqlSessionFactory的对象
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 使用SqlSessionFactory工厂对象创建SqlSession对象
        SqlSession session = factory.openSession();
        // 通过session创建UserMapper接口的代理对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        // 调用查询所有的方法
        List<User> list = mapper.findAll();
        // 遍历集合
        for (User user : list) {
            System.out.println(user);
        }
        // 释放资源
        session.close();
        in.close();
    }*/
    private InputStream in;
    private SqlSession session;
    private UserMapper mapper;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        mapper = session.getMapper(UserMapper.class);
    }

    @After
    public void destory() throws Exception {

        in.close();
        session.close();
    }

    @Test
    public void testFindAll() throws Exception {
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
        in.close();
    }

    @Test
    public void testFindById() {
        User user = mapper.findById(41);
        System.out.println(user);
    }

    @Test
    public void testInsert() {
        User u = new User();
        u.setUsername("jack");
        u.setAddress("newyork");
        u.setBirthday(new Date());
        u.setId(55);
        u.setSex("m");
        mapper.insert(u);
        session.commit();
        System.out.println(u);
    }

    @Test
    public void testDelete() {
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        mapper.delete(50);
        session.commit();
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);

        }
    }


    @Test
    public void testUpdate() {
        User user = mapper.findById(41);
        user.setUsername("white");
        mapper.update(user);
        session.commit();
        System.out.println(user);
    }

    @Test
    public void testFindByName() throws Exception {
        List<User> list = mapper.findByName("%王%");
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByCount() {
        int n = mapper.findByCount();
        System.out.println(n);
    }

}
