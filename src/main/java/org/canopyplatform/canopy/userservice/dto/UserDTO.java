package org.canopyplatform.canopy.userservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
	private Integer id;
	private String firstName;
	private String middleInitial;
	private String lastName;
	private String email;
	private String institution;
	private List<String> roles;
	/**
	 * Effective capabilities — the flat union of capabilities granted by the
	 * user's assigned roles (see role_capability). Populated by UserMapper.
	 * Frontends should gate fine-grained authorization (button visibility,
	 * page guards, conditional flows) on this field rather than on role
	 * names, so the DB remains the single source of truth for what a user
	 * can do.
	 */
	private List<String> capabilities;
	private String sessionID;
	private String jobTitle;
	private String orcidId;
	private String status;
	private Boolean dhpUser;
	private String researcherLevel;
	private String center;
	private String redirectUrl;
	private ZonedDateTime createdAt;
	private ZonedDateTime updateAt;

	public UserDTO(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
}
