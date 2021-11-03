package com.Source.note;

import com.Source.note.dao.BaseDao;
import com.Source.note.dao.UserDao;
import com.Source.note.po.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TestUser {
    @Test
    public void testQueryUserByName(){
        UserDao userDao =new UserDao();
        User user=userDao.queryUserByName("zhangsan");
        System.out.println(user.getUpwd());
    }
    @Test
    public void testAdd(){
        String sql="insert into tb_user (userName,upwd,head,nick,mood) values(?,?,?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add("wangzi");
        params.add("96888");
        params.add("404.jpg");
        params.add("Hello");
        params.add("good");
        int row= BaseDao.executeUpdate(sql,params);
        System.out.println(row);


    }
}
