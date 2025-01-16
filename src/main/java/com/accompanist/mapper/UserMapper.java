package com.accompanist.mapper;

import com.accompanist.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insert(User user);
    User findByEmail(String email);
    boolean existsByEmail(String email);
}