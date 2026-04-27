package org.canopyplatform.canopy.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.canopyplatform.canopy.userservice.entity.UserRole;

@Repository
public interface UserRoleRepository  extends JpaRepository<UserRole, Integer> {

	List<UserRole> findByRole_Name(String roleName);

}
