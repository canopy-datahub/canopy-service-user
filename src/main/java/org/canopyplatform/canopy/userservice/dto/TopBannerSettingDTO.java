package org.canopyplatform.canopy.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopBannerSettingDTO {
    private Boolean enabled;
    private String text;
    private String bgColor;
}
