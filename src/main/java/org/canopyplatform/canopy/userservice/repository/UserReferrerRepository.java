package org.canopyplatform.canopy.userservice.repository;

import org.canopyplatform.canopy.userservice.entity.UserReferrer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserReferrerRepository extends JpaRepository<UserReferrer, Integer> {}
