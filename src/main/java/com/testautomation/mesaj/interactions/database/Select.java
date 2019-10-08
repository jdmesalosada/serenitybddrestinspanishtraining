package com.testautomation.mesaj.interactions.database;

import com.testautomation.mesaj.abilities.InteractWithDb;
import com.testautomation.mesaj.database.entity.Example;
import com.testautomation.mesaj.interactions.Post;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Select<T> implements Interaction {

    private final String query;

    public Select(Class<T> cls ) {
        this.query = query;
    }

    @Step("{0} executes a SELECT query #query")
    @Override
    public <T extends Actor> void performAs(T actor) {
        EntityManager entityManager = InteractWithDb.as(actor).getManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Example> criteriaQuery = criteriaBuilder.createQuery(Example.class);
    }

    public static Select to(String query) {
        return instrumented(Select.class, query);
    }
}
