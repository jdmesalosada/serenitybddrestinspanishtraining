package com.testautomation.mesaj.models.users;

import lombok.*;

@Data
@EqualsAndHashCode(exclude = {"lastName"})
public class Foo {

    private String name;
    private String lastName;
    private String email;
    private int age;
}
