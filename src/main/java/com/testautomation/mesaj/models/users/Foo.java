package com.testautomation.mesaj.models.users;

import lombok.*;

@Data
@EqualsAndHashCode(exclude = {"lastName"})
@Builder
public class Foo {

    private String name;
    private String lastName;
    private String email;
    private int age;
}
