package com.lingfeng.camundastudy.dao.repo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lingfeng.camundastudy.common.mybatis.LambdaQueryWrapperX;
import com.lingfeng.camundastudy.dao.mapper.UserMapper;
import com.lingfeng.camundastudy.domain.dto.user.UserQueryDto;
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

    public IPage<UserEntity> queryByPage(UserQueryDto userQueryDto) {
        LambdaQueryWrapperX<UserEntity> queryWrapper = new LambdaQueryWrapperX<>();
        queryWrapper.likeIfPresent(UserEntity::getUsername, userQueryDto.getUsername());
        queryWrapper.eqIfPresent(UserEntity::getGender, userQueryDto.getGender());
        queryWrapper.eqIfPresent(UserEntity::getRole, userQueryDto.getRole());
        queryWrapper.orderByDesc(UserEntity::getId);
        IPage<UserEntity> page = new Page<>(userQueryDto.getPageNum(), userQueryDto.getPageSize());
        return this.page(page, queryWrapper);
    }
}
