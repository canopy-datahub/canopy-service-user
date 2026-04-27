package org.canopyplatform.canopy.userservice.mapper;

import org.canopyplatform.canopy.userservice.dto.LookupStateDTO;
import org.canopyplatform.canopy.userservice.entity.LookupState;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LookupStateMapper {
    LookupStateDTO toStateDto(LookupState lookupState);
}
