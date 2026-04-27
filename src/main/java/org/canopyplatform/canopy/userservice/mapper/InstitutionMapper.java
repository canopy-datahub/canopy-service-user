package org.canopyplatform.canopy.userservice.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.canopyplatform.canopy.userservice.dto.InstitutionDTO;
import org.canopyplatform.canopy.userservice.entity.Institution;

@Mapper(componentModel = "spring")
public interface InstitutionMapper {

    @Mapping(target = "status", source = "status.name")
    @Mapping(target = "type", source = "type.name")
    @Mapping(target = "country", source = "country.name")
    @Mapping(target = "state", source = "state.name")
    @Mapping(target = "province", source = "province")
    InstitutionDTO toInstitutionDto(Institution institution);

    List<InstitutionDTO> toInstitutionDTOs(List<Institution> institutions);

}
