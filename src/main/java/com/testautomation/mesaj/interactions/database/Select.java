package com.testautomation.mesaj.interactions.database;

import com.testautomation.mesaj.abilities.InteractWithDb;
import com.testautomation.mesaj.database.entity.Example;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Select implements Interaction {

    Class<?> clazz = null;

    public Select(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Step("{0} executes a SELECT query #query")
    @Override
    public <T extends Actor> void performAs(T actor) {
        EntityManager entityManager = InteractWithDb.as(actor).getManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<?> criteriaQuery = criteriaBuilder.createQuery(clazz);
        Root<?> root = criteriaQuery.from(clazz);

         entityManager
                .createQuery(criteriaQuery
                        .select(root));

        /*CriteriaDelete<Example> delete = criteriaBuilder.
                createCriteriaDelete(Example.class);

        Root e = delete.from(Example.class);
        delete.where(criteriaBuilder.equal(e.get("id"), 1));
        entityManager.createQuery(delete).executeUpdate();*/

        /*
        * EntityManager em = ...;
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Entity class> cq = cb.createQuery(Entity.class);
        Root<Entity> from = cq.from(Entity.class);
        cq.select(Entity);
        TypedQuery<Entity> q = em.createQuery(cq);
        List<Entity> allitems = q.getResultList()*/

        //https://docs.jboss.org/hibernate/entitymanager/3.5/reference/en/html/querycriteria.html

    }

    public static Select to(String query) {
        return instrumented(Select.class, query);
    }
}
