package com.Source.note;

import com.Source.note.util.DBUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDB {
    //使用日志工厂类，记录日志
    private Logger logger = LoggerFactory.getLogger(TestDB.class);
    @Test
    public void testDB(){
        System.out.println(DBUtil.getConnection());
        //使用日志
        logger.info("获取数据库连接："+DBUtil.getConnection());
        logger.info("获取数据库连接：{}",DBUtil.getConnection());
    }
}
