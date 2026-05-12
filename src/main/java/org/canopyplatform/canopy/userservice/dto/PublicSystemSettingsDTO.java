package org.canopyplatform.canopy.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Wire shape returned by the public system-settings endpoint. Add a new field
 * per public setting; private/admin-only settings should never appear here.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicSystemSettingsDTO {
    private TopBannerSettingDTO topBanner;
}
