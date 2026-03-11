package com.pedrodev.financialmanager.mapper;

import com.pedrodev.financialmanager.dto.UserDTO;
import com.pedrodev.financialmanager.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO dto);

    UserDTO toDTO(User user);

}
