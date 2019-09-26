package com.testautomation.mesaj.builders;

import com.testautomation.mesaj.models.users.Foo;

public class FooBuilder {

    private String name;
    private String lastName;
    private String email;
    private int age;

    public FooBuilder(String name) {
        this.name = name;
        this.lastName = "defaultLastnName";
        this.email = "defaultEmail";
        this.age = 50;
    }

    public static FooBuilder withName(String name){
        return new FooBuilder(name);
    }

    public FooBuilder andLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public FooBuilder andEmail(String email){
        this.email = email;
        return this;
    }

    public FooBuilder andAge(int age){
        this.age = age;
        return this;
    }

    public Foo build(){
        return new Foo(name, lastName, email, age);
    }
}
