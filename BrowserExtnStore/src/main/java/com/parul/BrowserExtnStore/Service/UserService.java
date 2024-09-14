package com.parul.BrowserExtnStore.Service;

import com.parul.BrowserExtnStore.Entity.User;
import com.parul.BrowserExtnStore.dto.UserRegistrationDto;

public interface UserService {
	User save(UserRegistrationDto registrationDto);
}
