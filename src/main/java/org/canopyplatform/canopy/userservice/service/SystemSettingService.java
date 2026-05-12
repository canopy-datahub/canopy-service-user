package org.canopyplatform.canopy.userservice.service;

import java.time.ZonedDateTime;
import java.util.regex.Pattern;

import org.canopyplatform.canopy.userservice.dto.PublicSystemSettingsDTO;
import org.canopyplatform.canopy.userservice.dto.TopBannerSettingDTO;
import org.canopyplatform.canopy.userservice.entity.SystemSetting;
import org.canopyplatform.canopy.userservice.exception.BadDataException;
import org.canopyplatform.canopy.userservice.exception.BadRequestException;
import org.canopyplatform.canopy.userservice.repository.SystemSettingRepository;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SystemSettingService {

    public static final String KEY_TOP_BANNER = "top_banner";

    // #RGB or #RRGGBB. Case-insensitive.
    private static final Pattern HEX_COLOR = Pattern.compile("^#([0-9a-fA-F]{3}|[0-9a-fA-F]{6})$");

    private final SystemSettingRepository repository;
    private final ObjectMapper objectMapper;

    public PublicSystemSettingsDTO getPublicSettings() {
        return new PublicSystemSettingsDTO(getTopBanner());
    }

    public TopBannerSettingDTO getTopBanner() {
        return repository.findById(KEY_TOP_BANNER)
                .map(s -> deserialize(s.getValue(), TopBannerSettingDTO.class))
                .orElseGet(() -> new TopBannerSettingDTO(false, "", "#ffc107"));
    }

    public TopBannerSettingDTO updateTopBanner(TopBannerSettingDTO dto, Integer updatedByUserId) {
        validateTopBanner(dto);
        SystemSetting row = repository.findById(KEY_TOP_BANNER).orElseGet(() -> {
            SystemSetting fresh = new SystemSetting();
            fresh.setKey(KEY_TOP_BANNER);
            return fresh;
        });
        row.setValue(serialize(dto));
        row.setUpdatedAt(ZonedDateTime.now());
        row.setUpdatedByUserId(updatedByUserId);
        repository.save(row);
        return dto;
    }

    private void validateTopBanner(TopBannerSettingDTO dto) {
        if (dto == null) {
            throw new BadRequestException("Banner settings are required.");
        }
        if (dto.getEnabled() == null) {
            throw new BadRequestException("Banner 'enabled' is required.");
        }
        if (dto.getBgColor() == null || !HEX_COLOR.matcher(dto.getBgColor()).matches()) {
            throw new BadRequestException("Banner 'bgColor' must be a hex color like #RRGGBB or #RGB.");
        }
        if (Boolean.TRUE.equals(dto.getEnabled())) {
            if (dto.getText() == null || dto.getText().trim().isEmpty()) {
                throw new BadRequestException("Banner 'text' must not be empty when the banner is enabled.");
            }
        }
        if (dto.getText() != null && dto.getText().length() > 500) {
            throw new BadRequestException("Banner 'text' must be 500 characters or fewer.");
        }
    }

    private <T> T deserialize(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            log.error("Failed to deserialize system_setting value for type {}: {}", type.getSimpleName(), e.getMessage());
            throw new BadDataException("Stored system setting value is malformed.");
        }
    }

    private String serialize(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            log.error("Failed to serialize system setting value: {}", e.getMessage());
            throw new BadDataException("Failed to encode system setting value.");
        }
    }
}
