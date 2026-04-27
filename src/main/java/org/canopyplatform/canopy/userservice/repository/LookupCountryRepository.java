package org.canopyplatform.canopy.userservice.repository;

import org.canopyplatform.canopy.userservice.entity.LookupCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LookupCountryRepository extends JpaRepository<LookupCountry, Integer> {

    Optional<LookupCountry> findByName(String name);

    List<LookupCountry> findAllByOrderByDisplayOrder();
}
