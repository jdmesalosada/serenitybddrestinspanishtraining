package com.testautomation.mesaj.abilities;

import com.testautomation.mesaj.database.DatabaseType;
import com.testautomation.mesaj.database.entity.Example;
import com.testautomation.mesaj.database.persistence.manager.JpaEntityManagerFactory;
import io.vavr.collection.Stream;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import javax.persistence.EntityManager;
import java.util.stream.Collectors;

public class InteractWithDb implements Ability {

    private EntityManager entityManager;

    public EntityManager getManager() {
        return entityManager;
    }

    private InteractWithDb() {
        this.entityManager =
                new JpaEntityManagerFactory(
                        DatabaseType.MYSQL, "jdbc:mysql://localhost/test_automation", "root",
                        "my-secret-pw",
                        Stream.of(
                                Example.class)
                                .map(Class::getName)
                                .collect(Collectors.toList())
                        ).getEntityManager();
    }

    public static InteractWithDb using(){
        return new InteractWithDb();
    }

    public static InteractWithDb as(Actor actor) {
        return actor.abilityTo(InteractWithDb.class);
    }
}
