package com.hami.learningenglishtabasom.auth;

import com.hami.learningenglishtabasom.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

    private String email;

    private String accessToken;


    public AuthResponse(User user, String newGenerateToken) {
    }
}
