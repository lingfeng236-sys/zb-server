package com.lingfeng.camundastudy.dao.repo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingfeng.camundastudy.dao.mapper.UserMapper;
import com.lingfeng.camundastudy.domain.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepo extends ServiceImpl<UserMapper, UserEntity> {

    public UserEntity getByUsername(String username) {
        LambdaQueryWrapper<UserEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserEntity::getUsername, username);
        return this.getOne(queryWrapper);
    }

    public Optional<UserEntity> findByUsername(String username) {
        return Optional.ofNullable(getByUsername( username));
    }
}
