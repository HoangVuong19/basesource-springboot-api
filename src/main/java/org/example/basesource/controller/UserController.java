package org.example.basesource.controller;

import lombok.RequiredArgsConstructor;
import org.example.basesource.dto.response.UserProfileResponse;
import org.example.basesource.service.IUserService;
import org.example.basesource.utils.UserContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;
    private final UserContext userContext;

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getMe() {
        String username = userContext.getCurrentUsername();
        UserProfileResponse userProfile = userService.getUserProfile(username);
        return ResponseEntity.ok(userProfile);
    }
}
