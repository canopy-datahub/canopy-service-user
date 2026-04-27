package org.canopyplatform.canopy.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.canopyplatform.canopy.userservice.entity.LkupCenter;

import java.util.Optional;

@Repository
public interface LkupCenterRepository extends JpaRepository<LkupCenter, Integer> {

    Optional<LkupCenter> findByName(String name);

}
