package org.canopyplatform.canopy.userservice.controller;

import org.canopyplatform.canopy.userservice.auth.core.KeycloakAuthenticationService;
import org.canopyplatform.canopy.userservice.dto.PublicSystemSettingsDTO;
import org.canopyplatform.canopy.userservice.dto.TopBannerSettingDTO;
import org.canopyplatform.canopy.userservice.service.SystemSettingService;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/system-settings")
public class SystemSettingController {

    private final SystemSettingService systemSettingService;
    private final KeycloakAuthenticationService authenticationService;

    /**
     * Public settings consumed on every page render (banner, etc.).
     * No authentication required so the banner is visible to anonymous visitors.
     * Short cache-control prevents hammering the DB on every SSR/CSR fetch.
     */
    @GetMapping("/public")
    public ResponseEntity<PublicSystemSettingsDTO> getPublicSettings() {
        return ResponseEntity.ok()
                .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS).cachePublic())
                .body(systemSettingService.getPublicSettings());
    }

    @GetMapping("/admin")
    public ResponseEntity<PublicSystemSettingsDTO> getAllSettings(@AuthenticationPrincipal Jwt jwt) {
        authenticationService.checkCapability(jwt, "system-settings.read");
        return ResponseEntity.ok(systemSettingService.getPublicSettings());
    }

    @PutMapping("/admin/top-banner")
    public ResponseEntity<TopBannerSettingDTO> updateTopBanner(@AuthenticationPrincipal Jwt jwt,
                                                               @RequestBody TopBannerSettingDTO dto) {
        Integer userId = authenticationService.checkCapability(jwt, "system-settings.update");
        return ResponseEntity.ok(systemSettingService.updateTopBanner(dto, userId));
    }
}
