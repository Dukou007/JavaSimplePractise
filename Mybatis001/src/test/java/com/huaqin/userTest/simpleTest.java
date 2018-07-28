package com.huaqin.userTest;

import com.huaqin.dao.UserMapper;
import com.huaqin.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class simpleTest {


    private InputStream in;
    private SqlSession session;
    private UserMapper mapper;

    @Before
    public  void init() throws  Exception{
        in=Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session=factory.openSession();
        mapper=session.getMapper(UserMapper.class);
    }
    @After
    public  void destory() throws  Exception{
        session.close();
        in.close();
    }

    @Test
    public void testFindAll(){
        List<User> users = mapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
