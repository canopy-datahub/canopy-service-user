package org.canopyplatform.canopy.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.canopyplatform.canopy.userservice.entity.LookupStatus;
import org.canopyplatform.canopy.userservice.entity.SupportRequest;

@Repository
public interface SupportRequestRepository  extends JpaRepository<SupportRequest, Integer> {

	List<SupportRequest> findByStatusUsageOrderByCreatedAtDesc(String statusUsage);

    List<SupportRequest> findByStatusOrderByCreatedAtDesc(LookupStatus status);

}
