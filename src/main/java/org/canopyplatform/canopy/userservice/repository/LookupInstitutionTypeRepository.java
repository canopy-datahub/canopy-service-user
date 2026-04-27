package org.canopyplatform.canopy.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.canopyplatform.canopy.userservice.entity.LookupInstitutionType;

import java.util.Optional;

@Repository
public interface LookupInstitutionTypeRepository extends JpaRepository<LookupInstitutionType, Long> {

    Optional<LookupInstitutionType> findByName(String name);

}
