package org.canopyplatform.canopy.userservice.mapper;

import org.canopyplatform.canopy.userservice.dto.LkupReferrerDTO;
import org.canopyplatform.canopy.userservice.entity.Institution;
import org.canopyplatform.canopy.userservice.entity.LkupReferrer;
import org.canopyplatform.canopy.userservice.entity.LookupResearcherLevel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.canopyplatform.canopy.userservice.dto.UserRegistrationDTO;
import org.canopyplatform.canopy.userservice.entity.User;

import java.util.List;

@Mapper(componentModel = "spring", uses = {InstitutionMapper.class})
public interface UserRegistrationMapper {

    @Mapping(source = "user.firstName", target = "firstName")
    @Mapping(source = "user.lastName", target = "lastName")
    @Mapping(source = "user.middleInitial", target = "middleInitial")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.orcidId", target = "orcidId")
    @Mapping(source = "user.jobTitle", target = "jobTitle")
    @Mapping(source = "user.acceptTerms", target = "acceptTerms")
    default String map(Institution institution) {
        return institution != null ? institution.getName() : null;
    }
    default String map(LookupResearcherLevel researcherLevel) {
        return researcherLevel != null ? researcherLevel.getName() : null;
    }
    UserRegistrationDTO toUserRegistrationtDto(User user);

    LkupReferrerDTO mapReferrer(LkupReferrer referrer);

    List<LkupReferrerDTO> mapReferrerTypes(List<LkupReferrer> referrers);

}
