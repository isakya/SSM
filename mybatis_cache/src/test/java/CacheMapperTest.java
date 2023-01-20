import com.izumi.mybatis.mapper.CacheMapper;
import com.izumi.mybatis.pojo.Emp;
import com.izumi.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    /**
     * Mybatis ��һ�����棺
     *  ˵����һ��������SqlSession����ģ���ͨ��SqlSession��ѯ�����ݻᱻ����
     *      �ٴ�ʹ��ͬһ��SqlSession��ѯͬһ�����ݣ���ӻ����л�ȡ
     *
     *  1) ��ͬ��SqlSession��Ӧ��ͬ��һ������
     *  2) ͬһ��SqlSession���ǲ�ѯ������ͬ
     *  3) ͬһ��SqlSession���� ��ѯ�ڼ� ִ�����κ�һ����ɾ�Ĳ���
     *  4) ͬһ��SqlSession���β�ѯ�ڼ��ֶ�����˻���
     *
     *
     *  �������棺
     *      MyBatis�Ķ���������SqlSessionFactory����ģ���ͨ��һ��SqlSessionFactory����ȡ��SqlSession����
     *      ��ѯ�����ݻᱻ���棬��ͨ��ͬһ��SqlSessionFactory����ȡ��SqlSession��ѯ��ͬ�����ݻ�ӻ����ȡ
     *      MyBatis�������濪����������
     *          a. �ں��������ļ��У�����ȫ���������� cacheEnabled="true",Ĭ��Ϊtrue������Ҫ����
     *          b. ��ӳ���ļ������ñ�ǩ<cache/>
     *          c. �������������SqlSession�رջ��ύ֮����Ч
     *          d. ��ѯ��������ת����ʵ�������ͱ���ʵ�����л��ӿ�
     *
     *      ʹ��������ʧЧ�������
     *          ���β�ѯ֮��ִ�����������ɾ�ģ���ʹһ���Ͷ�������ͬʱʧЧ
     */
    @Test
    public void testGetEmpById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        System.out.println(emp1);

        // ����������ɾ�Ĵ���....

        sqlSession.clearCache(); // �ֶ���ջ���

        Emp emp2 = mapper.getEmpById(1);
        System.out.println(emp2);
    }


    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        System.out.println(emp1);

        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println(emp2);

        sqlSession2.close();
    }
}
