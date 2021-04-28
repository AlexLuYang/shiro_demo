package com.alex.shirodemo.mapper;

import com.alex.shirodemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

     User getUserById(Integer id);

    User getUserByName(String name);
}
