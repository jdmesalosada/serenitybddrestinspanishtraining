package com.testautomation.mesaj;

import com.testautomation.mesaj.abilities.InteractWithDb;
import com.testautomation.mesaj.database.DatabaseConnectionInfo;
import com.testautomation.mesaj.database.DatabaseType;
import com.testautomation.mesaj.database.entity.Example;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SerenityRunner.class)
public class SerenityBddTest {

    private final String restApiUrl = "http://localhost:5000/api";

    @Test
    public void dataBaseConnectionTest() {

        DatabaseConnectionInfo connectionInfo = DatabaseConnectionInfo
                .builder()
                .username("root")
                .databaseType(DatabaseType.MYSQL)
                .url("jdbc:mysql://localhost/test_automation")
                .password("my-secret-pw")
                .entityNames(Stream.of(
                        Example.class)
                        .map(Class::getName)
                        .collect(Collectors.toList()))
                .build();


        Actor julian = Actor.named("julian");
        julian.can(InteractWithDb.using(connectionInfo));

        EntityManager entityManager = InteractWithDb.as(julian).getManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Example> criteriaQuery = criteriaBuilder
                .createQuery(Example.class);

        Root<Example> userRoot = criteriaQuery.from(Example.class);

        Example queryResult = entityManager
                .createQuery(criteriaQuery
                        .select(userRoot))
                .getSingleResult();

        System.out.println(queryResult);
    }
}
