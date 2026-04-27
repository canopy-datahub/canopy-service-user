package org.canopyplatform.canopy.userservice.service;

import java.io.IOException;
import java.util.List;

import org.canopyplatform.canopy.userservice.dto.SupportAssigneeDTO;
import org.canopyplatform.canopy.userservice.dto.SupportRequestDTO;

public interface SupportRequestService {

	List<String> getSupportRequestTypeNames();

    SupportRequestDTO saveSupportRequest(SupportRequestDTO supportRequestDTO);

    SupportRequestDTO getSupportRequestById(Integer id, Boolean isStaff);

    List<SupportRequestDTO> getAllSupportRequestsByStatus(String status);

    List<SupportRequestDTO> getAllSupportRequests();

    SupportRequestDTO updateSupportRequest(Integer userId, Integer id, SupportRequestDTO supportRequestDTO);

    List<Integer> getAllSeverities();

    List<String> getAllResolutionTypes();

    List<String> getAllStatuses();

    List<SupportAssigneeDTO> getAllAssignees();

    String downloadSupportRequestReportsToCSV() throws IOException;

    SupportRequestDTO saveLoggedInUserSupportRequest(SupportRequestDTO supportRequestDTO, Integer userId);
}
