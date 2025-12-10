package com.lingfeng.camundastudy.domain.dto.user;

import com.lingfeng.camundastudy.enums.user.GenderEnum;
import lombok.Data;

@Data
public class UserSaveDto {
    private String username;
    private String password;
    private GenderEnum gender;
}