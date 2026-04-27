package org.canopyplatform.canopy.userservice.repository;

import org.canopyplatform.canopy.userservice.entity.LookupState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LookupStateRepository extends JpaRepository<LookupState, Integer> {

    List<LookupState> findAllByOrderByDisplayOrder();

    Optional<LookupState> findByName(String name);
}
