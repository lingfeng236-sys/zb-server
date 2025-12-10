package com.lingfeng.camundastudy.convert;

import com.lingfeng.camundastudy.domain.dto.user.UserSaveDto;
import com.lingfeng.camundastudy.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserConvert {

    UserEntity UserSaveDto2Entity(UserSaveDto userSaveDto);
}
