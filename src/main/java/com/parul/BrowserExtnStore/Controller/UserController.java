package com.parul.BrowserExtnStore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parul.BrowserExtnStore.dto.UserProfileDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class UserController {

	@GetMapping("/userProfile")
	public UserProfileDTO getUserProfile(@AuthenticationPrincipal OAuth2User user, HttpServletRequest request, OAuth2AuthenticationToken authentication) {  //whenever the user logs in with Oauth2 provider, spring automatically creates an user object OAuth2User that stores the user credential 
		UserProfileDTO userProfileDTO = new UserProfileDTO(); 

		String ipAddress = request.getRemoteAddr();
		System.out.println("ip adddress : " + ipAddress);

		userProfileDTO.setImageURL(user.getAttribute("picture"));
		userProfileDTO.setEmail(user.getAttribute("email"));
		userProfileDTO.setName(user.getAttribute("name"));
		userProfileDTO.setLocale(user.getAttribute("locale"));

		System.out.println("name : " + user.getName());
		System.out.println("email : " + user.getAttribute("email"));
		System.out.println("image url : " + user.getAttribute("picture"));
		System.out.println("locale : " + user.getAttribute("locale"));

		String token = null;
		if (authentication.getPrincipal() instanceof OidcUser) {
			OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
			token = oidcUser.getIdToken().getTokenValue();
			System.out.println("Access Token retrieved");
		} else {
			token = authentication.getAuthorizedClientRegistrationId();
			System.out.println("Token from Authorized Client: {}" + token);
		}

		return userProfileDTO;
	}
}
