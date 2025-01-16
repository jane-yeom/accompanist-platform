package com.accompanist.mapper;

import com.accompanist.domain.AccompanistProfile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccompanistProfileMapper {
    void insert(AccompanistProfile profile);
    AccompanistProfile findByUserId(Long userId);
    void update(AccompanistProfile profile);
}