package com.izumi.mybatis.mapper;

import com.izumi.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 注意：
 * 1. 若sql语句查询的结果为 多条时，一定不能以实体类类型作为方法的返回值
 * 否则会抛出异常
 *
 * 2. 若sql语句查询的结果为 一条时，此时可以使用实体类类型或list集合类型作为方法的返回值
 */

public interface SelectMapper {
    // 根据id查询用户信息
    User getUserById(@Param("id") Integer id);

    // 查询所有的用户信息
    List<User> getAllUser();

    // 查询用户的总数量
    Integer getCount();

    // 根据id查询用户信息为map集合
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    // 查询所有的用户信息为map集合
    List<Map<String, Object>> getAllUserToMap(); // 解决方案一

    // @MapKey("id") // 把查询结果再放入一个map集合当中，以注解的id作为键，查询结果作为值
    // Map<String, Object> getAllUserToMap(); // 解决方案二
    /***
     * 查询所有的用户信息为map集合
     * 若查询的数据有多条时，并且要将每条数据转换为map集合
     * 此时解决方案如下：
     *
     *  1、将mapper接口方法的返回值设置为泛型map的list集合
     *
     *      如：List<Map<String, Object>> getAllUserToMap(); // 解决方案一
     *      查询结果：[{password=123456, gender=男, id=4, age=23, email=12345@qq.com, username=admin}, {password=123456, gender=1, id=10, age=33, email=123@qq.com, username=root}, {password=123456, gender=1, id=11, age=33, email=123@qq.com, username=root}]
     *
     *  2、可以将每条数据转换的map集合放在一个大的map中，但是必须要通过@MapKey注解，
     *     将查询的某个字段的值作为大的map键。
     *
     *     如：
     *          @MapKey("id") // 把查询结果再放入一个map集合当中，以注解的id作为键，查询结果作为值
     *          Map<String, Object> getAllUserToMap(); // 解决方案二
     *
     *     查询结果：{4={password=123456, gender=男, id=4, age=23, email=12345@qq.com, username=admin}, 10={password=123456, gender=1, id=10, age=33, email=123@qq.com, username=root}, 11={password=123456, gender=1, id=11, age=33, email=123@qq.com, username=root}}
     */
}
