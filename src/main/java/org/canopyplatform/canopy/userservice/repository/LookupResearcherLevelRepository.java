package org.canopyplatform.canopy.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.canopyplatform.canopy.userservice.entity.LookupResearcherLevel;

import java.util.Optional;

@Repository
public interface LookupResearcherLevelRepository extends JpaRepository<LookupResearcherLevel, Long> {

	Optional<LookupResearcherLevel> findByName(String name);

}
