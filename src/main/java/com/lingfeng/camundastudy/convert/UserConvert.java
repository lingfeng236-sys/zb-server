package com.lingfeng.camundastudy.convert;

import com.lingfeng.camundastudy.domain.dto.user.UserDto;
import com.lingfeng.camundastudy.domain.dto.user.UserSaveDto;
import com.lingfeng.camundastudy.domain.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface UserConvert {

    UserEntity UserSaveDto2Entity(UserSaveDto userSaveDto);

    UserDto userEntity2Dto(UserEntity userEntity);

    List<UserDto> userEntityList2DtoList(List<UserEntity> userEntityList);
}
