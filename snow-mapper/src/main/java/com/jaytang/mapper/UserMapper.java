package com.jaytang.mapper;

import com.jaytang.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by jaytangchn on 2018/8/18.
 */
public interface UserMapper {
    User getUser(@Param("id")String id);
}
