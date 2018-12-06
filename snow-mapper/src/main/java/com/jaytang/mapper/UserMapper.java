package com.jaytang.mapper;

import com.jaytang.model.Role;
import com.jaytang.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jaytangchn on 2018/8/18.
 */
public interface UserMapper {
    User getUser(@Param("id")int id);

    String getPwd(@Param("name")String name);

    List<Role> getRoles(@Param("user")User user);
}
