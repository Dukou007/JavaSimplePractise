package com.huaqin.test;

import com.huaqin.domain1.QueryVo;
import com.huaqin.domain1.User;
import com.huaqin.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {

    private InputStream in;
    private SqlSession session;
    private UserMapper mapper;


    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        mapper = session.getMapper(UserMapper.class);
    }

    @After
    public void destory() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void testFindByUserName() {
        User u = new User();
        u.setUsername("jack");
        List<User> users = mapper.findByUserName(u);
        for (User user : users) {
            System.out.println(user);
        }
    }


    @Test
    public void testFindByQueryVo(){


        QueryVo vo = new QueryVo();
        User u = new User();
        u.setUsername("jack");
        vo.setUser(u);
        List<User> vos = mapper.findByQueryVo(vo);
        for (User user : vos) {
            System.out.println(user);
        }
    }
}
