package com.testautomation.mesaj.models.users;

import lombok.Builder;

@Builder
public class RegisterUserInfo {

    private String name;
    private String job;
    private String email;
    private String password;
}
