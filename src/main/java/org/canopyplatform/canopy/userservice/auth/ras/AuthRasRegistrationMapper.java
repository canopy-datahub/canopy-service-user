package org.canopyplatform.canopy.userservice.auth.ras;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthRasRegistrationMapper {

    AuthRasRegistrationDTO toRasRegistrationDto(AuthRasTracking rasTracking);

}
