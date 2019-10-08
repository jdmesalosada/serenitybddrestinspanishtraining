package com.testautomation.mesaj;

import com.testautomation.mesaj.abilities.InteractWithDb;
import com.testautomation.mesaj.builders.FooBuilder;
import com.testautomation.mesaj.database.entity.Example;
import com.testautomation.mesaj.facts.NetflixPlans;
import com.testautomation.mesaj.models.users.Datum;
import com.testautomation.mesaj.models.users.Foo;
import com.testautomation.mesaj.questions.GetUsersQuestion;
import com.testautomation.mesaj.questions.ResponseCode;
import com.testautomation.mesaj.tasks.GetUsers;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SerenityRunner.class)
public class SerenityBddTest {

    private final String restApiUrl = "http://localhost:5000/api";

    @Test
    public void initiala() {
       /* Foo foo = new Foo();
        foo.setName("algo");
        foo.setAge(10);
        foo.setLastName("algomas");

        Foo foo1 = new Foo();
        foo1.setName("algo");
        foo1.setAge(10);

        System.out.println(foo1.toString());
        System.out.println(foo.toString());

        System.out.println(foo.equals(foo1));*/


        Foo foo2 = FooBuilder
                .withName("Pepito")
                .build();

        Foo foo3 = FooBuilder
                .withName("Pepito")
                .andAge(10)
                .andLastName("Rodriguez")
                .build();

        System.out.println(foo2.toString());
        System.out.println(foo3.toString());
    }

    @Test
    public void initialTest() {
        Actor julian = Actor.named("Julian the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        julian.attemptsTo(
                GetUsers.fromPage(1)
        );

        julian.should(
                seeThat("el codigo de respuesta", new ResponseCode(), equalTo(200))
        );


        Datum user = new GetUsersQuestion().answeredBy(julian)
                .getData().stream().filter(x -> x.getId() == 1).findFirst().orElse(null);


        julian.should(
                seeThat("usuario no es nulo", act -> user, notNullValue())
        );

        julian.should(
                seeThat("el email del usuario", act -> user.getEmail(), equalTo("george.bluth@reqres.in")),
                seeThat("el avatar del usuario", act -> user.getAvatar(), equalTo("avatar"))
        );
    }

    @Test
    public void registerUserTest() {
        /*Actor julian = Actor.named("Julian the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        String registerUserInfo = "{\n" +
                "\t\"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\",\n" +
                "    \"email\": \"tracey.ramos@reqres.in\",\n" +
                "    \"password\": \"serenity\"\n" +
                "}";

        julian.attemptsTo(
                RegisterUser.withInfo(registerUserInfo)

        );

        julian.should(
                seeThat("el codigo de respuesta", new ResponseCode(), equalTo(200))
        );*/

    }

    @Test
    public void registerUserTest2() {
       /* Actor julian = Actor.named("Julian the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        RegisterUserInfo registerUserInfo = new RegisterUserInfo();

        registerUserInfo.setName("morpheus");
        registerUserInfo.setJob("leader");
        registerUserInfo.setEmail("tracey.ramos@reqres.in");
        registerUserInfo.setPassword("serenity");

        julian.attemptsTo(
                RegisterUser.withInfo(registerUserInfo)

        );

        julian.should(
                seeThat("el codigo de respuesta", new ResponseCode(), equalTo(200))
        );*/
    }

    @Test
    public void factTest() {
        Actor julian = Actor.named("Julian the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        julian.has(NetflixPlans.toViewSeries());
    }


    @Test
    public void dataBaseConnectionTest() {

        /*SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Example> criteriaQuery = cb.createQuery(Example.class);

        Root<Example> root = criteriaQuery.from(Example.class);

        criteriaQuery.select(root).where(cb.equal(root.get("gradYear"), 1965));

        sessionFactory.close();*/

        /*Map properties = new HashMap();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-query-types", properties);

        EntityManager em = emf.createEntityManager();

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<UserEntity> criteriaQuery = criteriaBuilder.createQuery(UserEntity.class);

        Root<UserEntity> userRoot = criteriaQuery.from(UserEntity.class);

        UserEntity queryResult = getEntityManager().createQuery(criteriaQuery.select(userRoot)
                .where(criteriaBuilder.equal(userRoot.get("id"), id)))
                .getSingleResult();*/

        Actor julian = Actor.named("julian");
        julian.can(InteractWithDb.using());

        EntityManager entityManager = InteractWithDb.as(julian).getManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Example> criteriaQuery = criteriaBuilder.createQuery(Example.class);
        Root<Example> userRoot = criteriaQuery.from(Example.class);

        Example queryResult = entityManager
                .createQuery(criteriaQuery
                        .select(userRoot))
                .getSingleResult();

        System.out.println(queryResult);
    }
}
