import org.lsh.mybatis.entity.TUser;
import org.lsh.mybatis.mapper.TUserMapper;
import org.lsh.mybatis.session.SqlSession;
import org.lsh.mybatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Title: java类的类型
 * @Author: lsh
 * @CreateDate: 2018/8/24 11:31
 */
public class TestMybatis {
    public static void main(String[] args) {
        //1.实例化SqlSessionFactory,加载数据库配置文件以及mapper.xml文件到configuration对象中
        SqlSessionFactory factory = new SqlSessionFactory();
        SqlSession session = factory.openSession();
        System.out.println(session);

        TUserMapper userMapper = session.getMapper(TUserMapper.class);

        TUser user = userMapper.selectByPrimaryKey("1");
        System.out.println(user);

        System.out.println("------------------------");

        List<TUser> userList= userMapper.selectAll();
        for (TUser u:userList) {
            System.out.println(u);
            System.out.println("++++++++");
        }
    }
}
