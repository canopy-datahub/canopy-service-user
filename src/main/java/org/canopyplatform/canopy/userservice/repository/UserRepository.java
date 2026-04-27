package org.canopyplatform.canopy.userservice.repository;

import java.util.List;
import java.util.Optional;

import org.canopyplatform.canopy.userservice.entity.LookupStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.canopyplatform.canopy.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String emailAddress);

    boolean existsByEmail(String emailAddress);

    List<User> findByStatus_NameAndStatus_Usage(String statusName, String statusUsage);

    List<User> findByStatusOrderByCreatedAtDesc(LookupStatus status);
}
