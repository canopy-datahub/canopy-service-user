package org.canopyplatform.canopy.userservice.repository;

import org.canopyplatform.canopy.userservice.entity.SystemSetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemSettingRepository extends JpaRepository<SystemSetting, String> {
}
