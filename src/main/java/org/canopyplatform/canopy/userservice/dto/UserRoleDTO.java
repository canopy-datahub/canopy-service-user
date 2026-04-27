package org.canopyplatform.canopy.userservice.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserRoleDTO {
    private Integer id;
    private UserDTO user;
    private RoleDTO role;
}
