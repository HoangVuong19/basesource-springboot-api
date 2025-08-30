package org.example.basesource.service;

import org.example.basesource.dto.response.UserProfileResponse;

public interface IUserService {
    UserProfileResponse getUserProfile(String username);
} 