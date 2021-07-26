package cn.demo.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {

        try {
            String resource = "mybatis-config.xml";
            //使用mybatis的第一步：获取 sqlSessionFactory 对象
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //有了sqlSessionFactory就可以使用实例
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
