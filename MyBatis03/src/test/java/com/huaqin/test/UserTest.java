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
import java.util.ArrayList;
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

    @Test
    public void testFindByWhere(){
        QueryVo vo = new QueryVo();
        User u = new User();
        u.setUsername("老王");
        u.setUserSex("男");
        vo.setUser(u);
        List<User> users = mapper.findByWhere(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByIds(){
        QueryVo vo = new QueryVo();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(41);
        list.add(42);
        list.add(43);
        list.add(44);
        list.add(45);
        vo.setIds(list);
        List<User> ids = mapper.findByIds(vo);
        for (User id : ids) {
            System.out.println(id);
        }
    }

    @Test
    public void testFindAllUser(){
        QueryVo vo = new QueryVo();
        User u = new User();
        vo.setUser(u);

        List<User> users = mapper.findAllUser(vo);
        for (User user : users) {
            System.out.println(user);
        }
    }
}
