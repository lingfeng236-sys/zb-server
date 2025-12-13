package com.lingfeng.camundastudy.domain.dto.user;

import com.lingfeng.camundastudy.enums.user.GenderEnum;
import com.lingfeng.camundastudy.enums.user.RoleEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UserSaveDto {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @Length(min = 6, message = "密码长度至少6位")
    private String password;
    private GenderEnum gender = GenderEnum.UNKNOWN;
    private RoleEnum role;
}