package com.example.demo.mappers;



import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface UserMapper{
    //查询全部
    //在这里我利用了sql优化，之查出相应的字段，避免出现*号
    @Select("select * from suer1")
    List<User> selectUserByName();


    @Delete("delete from suer1 where id = #{id}")
    int deleteById(@Param("id") String id);

    @Insert({ "insert into suer1(id, name, sex, age, classes) values(#{id}, #{name}, #{sex}, #{age}, #{classes})" })

    int add(User user);


}
