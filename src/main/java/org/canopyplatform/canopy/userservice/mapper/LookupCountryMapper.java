package org.canopyplatform.canopy.userservice.mapper;

import org.canopyplatform.canopy.userservice.entity.LookupCountry;
import org.canopyplatform.canopy.userservice.dto.LookupCountryDTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LookupCountryMapper {
    LookupCountryDTO toCountryDto(LookupCountry lookupCountry);
}
