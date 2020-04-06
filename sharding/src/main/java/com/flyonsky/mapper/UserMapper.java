package com.flyonsky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flyonsky.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author luowengang
 * @date 2020/4/6 15:06
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
