package com.lingfeng.camundastudy.domain.dto.user;

import com.lingfeng.camundastudy.common.domain.BasePageDto;
import com.lingfeng.camundastudy.enums.user.GenderEnum;
import com.lingfeng.camundastudy.enums.user.RoleEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryDto extends BasePageDto {
    private String username;
    private GenderEnum gender;
    private RoleEnum role;

}
