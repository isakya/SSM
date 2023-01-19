import com.izumi.mybatis.mapper.SelectMapper;
import com.izumi.mybatis.pojo.User;
import com.izumi.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(4);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(4);
        System.out.println(map);
        // 注意：如果某个字段为null，则不会放到查询结果当中
        // {password=123456, gender=男, id=4, age=23, email=12345@qq.com, username=admin}
    }

    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

        List<Map<String, Object>> list = mapper.getAllUserToMap();
        // 查询结果：[{password=123456, gender=男, id=4, age=23, email=12345@qq.com, username=admin}, {password=123456, gender=1, id=10, age=33, email=123@qq.com, username=root}, {password=123456, gender=1, id=11, age=33, email=123@qq.com, username=root}]

        // Map<String, Object> map = mapper.getAllUserToMap();
        // 查询结果：{4={password=123456, gender=男, id=4, age=23, email=12345@qq.com, username=admin}, 10={password=123456, gender=1, id=10, age=33, email=123@qq.com, username=root}, 11={password=123456, gender=1, id=11, age=33, email=123@qq.com, username=root}}

        System.out.println(list);
    }
}
