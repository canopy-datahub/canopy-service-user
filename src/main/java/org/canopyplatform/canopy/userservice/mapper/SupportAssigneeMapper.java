package org.canopyplatform.canopy.userservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import org.canopyplatform.canopy.userservice.dto.SupportAssigneeDTO;
import org.canopyplatform.canopy.userservice.entity.UserRole;

@Mapper(componentModel = "spring")
public interface SupportAssigneeMapper {

	@Mapping(source = "user.id", target = "id")
	@Mapping(source = "user.firstName", target = "firstName")
	@Mapping(source = "user.middleInitial", target = "middleInitial")
	@Mapping(source = "user.lastName", target = "lastName")
	@Mapping(source = "user.email", target = "email")
	SupportAssigneeDTO toSupportAssigneeDto(UserRole user);

	List<SupportAssigneeDTO> toDTOs(List<UserRole> supportUsers);

}
