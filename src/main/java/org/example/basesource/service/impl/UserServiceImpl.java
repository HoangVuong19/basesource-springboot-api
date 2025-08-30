package org.example.basesource.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.basesource.dto.response.UserProfileResponse;
import org.example.basesource.entity.User;
import org.example.basesource.exception.*;
import org.example.basesource.repository.IUserRepository;
import org.example.basesource.service.IUserService;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;


    @Override
    public UserProfileResponse getUserProfile(String username) {
        ValidateRequest valid = getValidateRequest(username);

        return UserProfileResponse.builder()
                .email(valid.user().getUsername())
                .updatedAt(valid.formattedUpdatedAt())
                .build();
    }

    private ValidateRequest getValidateRequest(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new NotFoundException("User not found");
        }

        User user = userOptional.get();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        String formattedUpdatedAt = user.getUpdatedAt() != null
                ? user.getUpdatedAt().format(formatter)
                : null;
        return new ValidateRequest(user, formattedUpdatedAt, formatter);
    }

    private record ValidateRequest(User user, String formattedUpdatedAt, DateTimeFormatter formatter) {
    }
}