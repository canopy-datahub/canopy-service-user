package org.canopyplatform.canopy.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.canopyplatform.canopy.userservice.entity.ResolutionType;

import java.util.Optional;

public interface ResolutionTypeRepository extends JpaRepository<ResolutionType, Long> {

	Optional<ResolutionType> findByName(String name);

}

