package com.lingfeng.camundastudy.domain.dto.user;

import com.lingfeng.camundastudy.common.domain.BaseDto;
import com.lingfeng.camundastudy.enums.user.GenderEnum;
import com.lingfeng.camundastudy.enums.user.RoleEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends BaseDto {
    private Long id;
    private String username;
    private String password;
    private GenderEnum gender;
    private RoleEnum role;
    private String nickname;
}
