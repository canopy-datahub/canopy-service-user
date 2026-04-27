package org.canopyplatform.canopy.userservice.service;

import java.util.List;

import org.canopyplatform.canopy.userservice.dto.*;
import org.canopyplatform.canopy.userservice.entity.LkupCenter;
import org.canopyplatform.canopy.userservice.entity.Role;

public interface UserService {

    UserDTO getUserInfo(String emailAddress);

    List<InstitutionDTO> getApprovedInstitutions();

    InstitutionDTO createInstitution(InstitutionDTO institutionDTO);

    UserRegistrationDTO saveUserRegistrationForm(Integer userId, UserRegistrationDTO userRegistrationDTO);

    List<String> getResearcherLevels();

    List<String> getAllInstitutionTypes();

    List<LookupStateDTO> getAllStates();

    List<LookupCountryDTO> getAllCountries();

    List<LkupCenter> getAllCenters();

    List<UserDTO> getUsersByStatus(String status);

    List<Role> getAllRoles();

    List<String> getGeneralStatus();

    UserDTO getUserInfoById(Integer id);

    UserDTO updateUserInfo(Integer id, UserDTO userDTO);

    UserDTO editProfile(Integer id, UserDTO userDTO);

    List<LkupReferrerDTO> getReferrerTypes();

}
