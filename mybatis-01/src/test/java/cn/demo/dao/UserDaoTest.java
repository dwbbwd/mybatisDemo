package cn.demo.dao;

import cn.demo.pojo.User;
import cn.demo.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        //获得sqlSession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行方式1
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = mapper.getUserList();
        //方式2
//        List<User> userList = sqlSession.selectList("cn.demo.dao.UserDao.getUserList");

        for (User user:userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
