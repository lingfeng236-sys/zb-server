package com.lingfeng.camundastudy.service.user;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lingfeng.camundastudy.common.constant.CommonStateCode;
import com.lingfeng.camundastudy.common.exception.BizException;
import com.lingfeng.camundastudy.common.util.CollectionUtils;
import com.lingfeng.camundastudy.common.util.JwtUtil;
import com.lingfeng.camundastudy.common.util.NumberUtils;
import com.lingfeng.camundastudy.common.util.StrUtils;
import com.lingfeng.camundastudy.convert.UserConvert;
import com.lingfeng.camundastudy.dao.repo.UserRepo;
import com.lingfeng.camundastudy.domain.dto.user.UserDto;
import com.lingfeng.camundastudy.domain.dto.user.UserQueryDto;
import com.lingfeng.camundastudy.domain.dto.user.UserSaveDto;
import com.lingfeng.camundastudy.domain.entity.UserEntity;
import com.lingfeng.camundastudy.enums.user.RoleEnum;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    @Resource
    private PasswordEncoder passwordEncoder;

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
        Optional<UserEntity> userEntityOptional = userRepo.findByUsername(userSaveDto.getUsername());
        if (userEntityOptional.isPresent()) {
            throw new BizException(CommonStateCode.USER_ALREADY_EXIST);
        }

        // 使用 MapStruct 映射器转换 DTO 到 Entity
        UserEntity userEntity = userConvert.UserSaveDto2Entity(userSaveDto);
        // 加密密码
        userEntity.setPassword(passwordEncoder.encode(userSaveDto.getPassword()));
        userEntity.setRole(RoleEnum.USER);
        userRepo.save(userEntity);
    }

    public UserDto detail(Long id) {
        UserEntity userEntity = userRepo.getById(id);
        return userConvert.userEntity2Dto(userEntity);
    }

    /**
     * 分页查询用户列表
     */
    public IPage<UserDto> page(UserQueryDto userQueryDto) {
        IPage<UserEntity> result = userRepo.queryByPage(userQueryDto);
        IPage<UserDto> resultPage = new Page<>(result.getCurrent(), result.getSize(), result.getTotal());
        List<UserEntity> userEntityList = result.getRecords();
        if (CollectionUtils.isEmpty(userEntityList)) {
            return resultPage;
        }
        return resultPage.setRecords(userConvert.userEntityList2DtoList(userEntityList));
    }

    /**
     * 删除用户
     */
    public Boolean delete(Long id) {
        return userRepo.removeById(id);
    }

    public void addOrEdit(UserSaveDto userSaveDto) {
        if (NumberUtils.isNull(userSaveDto.getId())) {
            userSaveDto.setRole(RoleEnum.USER);
            register(userSaveDto);
        } else {
            // 编辑
            // 1. 先查出数据库里的原数据
            UserEntity oldUser = userRepo.getById(userSaveDto.getId());
            if(oldUser == null) {
                throw new BizException(CommonStateCode.USER_NOT_EXIST);
            };

            // 2. 转换
            UserEntity userEntity = userConvert.UserSaveDto2Entity(userSaveDto);

            // 3. 特殊处理密码：如果前端没传密码（空字符串），则使用数据库原密码
            if (StrUtils.isBlank(userSaveDto.getPassword())) {
                userEntity.setPassword(oldUser.getPassword());
            } else {
                // 如果传了新密码，记得加密！
                userEntity.setPassword(passwordEncoder.encode(userSaveDto.getPassword()));
            }

            userRepo.updateById(userEntity);
        }
    }
}