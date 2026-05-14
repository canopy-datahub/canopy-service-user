package org.canopyplatform.canopy.userservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import org.canopyplatform.canopy.userservice.dto.UserDTO;
import org.canopyplatform.canopy.userservice.entity.Capability;
import org.canopyplatform.canopy.userservice.entity.Role;
import org.canopyplatform.canopy.userservice.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(target = "institution", source = "institution.name")
	@Mapping(target = "roles", source = "user.roles", qualifiedByName = "extractRoles")
	@Mapping(target = "capabilities", source = "user.roles", qualifiedByName = "extractCapabilities")
	@Mapping(target = "jobTitle", source = "jobTitle")
	@Mapping(target = "status", source = "status.name")
	@Mapping(target = "researcherLevel", source = "user.researcherLevel.name")
	@Mapping(target = "center", source = "user.center.name")
	UserDTO toUserDto(User user);

	@Mapping(target = "institution", source = "user.institution.name")
	@Mapping(target = "roles", source = "user.roles", qualifiedByName = "extractRoles")
	@Mapping(target = "capabilities", source = "user.roles", qualifiedByName = "extractCapabilities")
	@Mapping(target = "jobTitle", source = "user.jobTitle")
	@Mapping(target = "status", source = "user.status.name")
	@Mapping(target = "sessionID", source = "session")
	@Mapping(target = "researcherLevel", source = "user.researcherLevel.name")
	@Mapping(target = "center", source = "user.center.name")
	UserDTO toUserDto(User user, String session);

	List<UserDTO> toUserDTOs(List<User> users);

    @Named("extractRoles")
	static List<String> extractRoles(List<Role> roles){
		return roles.stream().map(Role::getName).toList();
	}

	@Named("extractCapabilities")
	static List<String> extractCapabilities(List<Role> roles){
		if (roles == null) return List.of();
		return roles.stream()
				.filter(r -> r.getCapabilities() != null)
				.flatMap(r -> r.getCapabilities().stream())
				.map(Capability::getName)
				.distinct()
				.toList();
	}
}
