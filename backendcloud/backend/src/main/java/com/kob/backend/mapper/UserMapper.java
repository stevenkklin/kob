package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Steven
 * @create 2023-03-15-8:53
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
