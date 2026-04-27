package org.canopyplatform.canopy.userservice.service;

import org.canopyplatform.canopy.userservice.dto.EmailRequest;
import org.canopyplatform.canopy.userservice.entity.SupportRequest;
import org.canopyplatform.canopy.userservice.entity.User;
import org.canopyplatform.canopy.userservice.util.EmailRequestType;

public interface MessageService {

    boolean sendMessage(EmailRequest emailRequest);

    EmailRequest createUserSupportEmailRequest(SupportRequest supportRequest, EmailRequestType requestType);

    EmailRequest  createSupportAssignmentEmailRequest(SupportRequest supportRequest, String supportStaffName);

    boolean sendWelcomeEmail(User user);

}
