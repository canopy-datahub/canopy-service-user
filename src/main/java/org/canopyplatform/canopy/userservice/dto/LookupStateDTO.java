package org.canopyplatform.canopy.userservice.dto;

import lombok.Data;

@Data
public class LookupStateDTO {
    private Integer id;
    private String name;
    private String abbreviation;
    private Integer displayOrder;
}
