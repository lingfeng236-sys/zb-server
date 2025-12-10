package com.lingfeng.camundastudy.service.user;

import com.lingfeng.camundastudy.common.constant.CommonStateCode;
import com.lingfeng.camundastudy.common.exception.BizException;
import com.lingfeng.camundastudy.convert.UserConvert;
import com.lingfeng.camundastudy.dao.repo.UserRepo;
import com.lingfeng.camundastudy.domain.dto.user.UserDto;
import com.lingfeng.camundastudy.domain.dto.user.UserSaveDto;
import com.lingfeng.camundastudy.domain.entity.UserEntity;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Resource
    private UserRepo userRepo;

    @Resource
    private UserConvert  userConvert;

    /**
     * 登录功能
     */
    public String login(UserSaveDto userSaveDto) {


        UserEntity user = userRepo.getByUsername(userSaveDto.getUsername());

        // 3. 校验用户是否存在
        if (user == null) {
            throw new BizException(CommonStateCode.USER_NOT_EXIST);
        }

        // 4. 校验密码
        // 注意：实际项目中请使用 BCryptPasswordEncoder 或 MD5 加密对比
        // 示例：if (!BCrypt.checkpw(loginDTO.getPassword(), user.getPassword()))
        if (!user.getPassword().equals(userSaveDto.getPassword())) {
            throw new BizException(CommonStateCode.USER_PASSWORD_ERROR);
        }

        // 5. 登录成功，生成 Token (这里模拟返回一个 token 字符串)
        // 实际开发中通常使用 JWT (Json Web Token)
        return "Login_Success_Token_" + user.getId();
    }

    /**
     * 新增用户（注册）
     */
    public void register(UserSaveDto userSaveDto) {

        // 检查用户名是否重复
        UserEntity existingUser = userRepo.getByUsername(userSaveDto.getUsername());
        if (existingUser != null) {
            throw new BizException(CommonStateCode.USER_ALREADY_EXIST);
        }
        
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