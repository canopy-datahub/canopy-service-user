package org.canopyplatform.canopy.userservice.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthLookupStatusRepository extends JpaRepository<AuthLookupStatus, Integer> {
}
