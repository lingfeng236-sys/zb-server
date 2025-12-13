package com.lingfeng.camundastudy.service.user;

import com.lingfeng.camundastudy.common.constant.CommonStateCode;
import com.lingfeng.camundastudy.common.exception.BizException;
import com.lingfeng.camundastudy.common.util.JwtUtil;
import com.lingfeng.camundastudy.convert.UserConvert;
import com.lingfeng.camundastudy.dao.repo.UserRepo;
import com.lingfeng.camundastudy.domain.dto.user.UserDto;
import com.lingfeng.camundastudy.domain.dto.user.UserSaveDto;
import com.lingfeng.camundastudy.domain.entity.UserEntity;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Resource
    private UserRepo userRepo;

    @Resource
    private UserConvert userConvert;

    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private JwtUtil jwtUtil;

    /**
     * 登录功能
     */
    public String login(UserSaveDto userSaveDto) {
        // 1. 创建认证令牌
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userSaveDto.getUsername(), userSaveDto.getPassword());

        // 2. 调用 AuthenticationManager 进行认证
        // 如果认证失败（密码错误），这里会抛出异常
        authenticationManager.authenticate(authenticationToken);

        // 3. 认证成功，生成 Token 并返回
        return jwtUtil.generateToken(userSaveDto.getUsername());
    }

    /**
     * 新增用户（注册）
     */
    public void register(UserSaveDto userSaveDto) {

        // 检查用户名是否重复
        UserEntity existingUser = userRepo.findByUsername(userSaveDto.getUsername()).orElseThrow(() -> new BizException(CommonStateCode.USER_ALREADY_EXIST));

        // 使用 MapStruct 映射器转换 DTO 到 Entity
        UserEntity userEntity = userConvert.UserSaveDto2Entity(userSaveDto);
        // 实际存储前请加密密码：user.setPassword(encode(user.getPassword()));
        userRepo.save(userEntity);
    }

    public UserDto detail(Long id) {
        UserEntity userEntity = userRepo.getById(id);
        return userConvert.userEntity2Dto(userEntity);
    }
}