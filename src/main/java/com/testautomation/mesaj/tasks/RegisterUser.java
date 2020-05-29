package com.testautomation.mesaj.tasks;

import com.testautomation.mesaj.interactions.Post;
import com.testautomation.mesaj.models.users.RegisterUserInfo;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

public class RegisterUser implements Task {

    private final RegisterUserInfo userInfo;

    public RegisterUser(RegisterUserInfo userInfo) {
        this.userInfo = userInfo;
    }

    /*public static Performable withInfo(RegisterUserInfo userInfo) {
        return instrumented(RegisterUser.class, userInfo);
    }*/

    public static RegisterUserBuilder withName(String name) {
        return new RegisterUserBuilder(name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/register").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );
    }

    public static class RegisterUserBuilder {

        private String name;
        private String password;
        private String email;
        private String job;

        public RegisterUserBuilder(String name){
            this.name = name;
        }

        public RegisterUserBuilder andPassword(String password)
        {
            this.password = password;
            return this;
        }

        public RegisterUserBuilder andEmail(String email)
        {
            this.email = email;
            return this;
        }

        public RegisterUser andJob(String job)
        {
            this.job = job;

            return new RegisterUser(RegisterUserInfo.builder()
                    .name(this.name)
                    .password(this.password)
                    .email(this.email)
                    .job(this.job)
                    .build());
        }
    }
}
