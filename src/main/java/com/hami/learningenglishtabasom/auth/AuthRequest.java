package com.hami.learningenglishtabasom.auth;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Setter
@Getter
public class AuthRequest {

    @Email
    @Length(min = 5, max = 120)
    private String email;

    @Length(min = 5, max = 20)
    private String password;

    private String firstName;

    private String lastName;
}
