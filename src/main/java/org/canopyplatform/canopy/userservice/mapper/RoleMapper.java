package org.canopyplatform.canopy.userservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import org.canopyplatform.canopy.userservice.dto.RoleDTO;
import org.canopyplatform.canopy.userservice.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toRoleDto(Role role);

    List<RoleDTO> toDTOs(List<Role> roles);

}

