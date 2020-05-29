Add database connection ability to actor.

> docker run -p 3306:3306 --name mysql2 -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:5.7
> docker container ls
>  docker exec -it mysql2 mysql -uroot -p   -> start mysql client.
> CREATE DATABASE test_automation;
> USE test_automation;
> CREATE TABLE example ( id smallint unsigned not null auto_increment, name varchar(20) not null, constraint pk_example primary key (id) ); INSERT INTO example ( id, name ) VALUES ( null, 'Julian Mesa' );
> SELECT * FROM example;
> DESCRIBE example;



> Add the following maven dependencies:

    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.4.1.Final</version>
    </dependency>

	<dependency>
    	<groupId>org.hibernate</groupId>
    	<artifactId>hibernate-entitymanager</artifactId>
    	<version>5.4.1.Final</version>
	</dependency>

	<dependency>
    	<groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.15</version>
        <scope>provided</scope>
    </dependency>

> Let's create a new package: database -> inside another package called: entity
> Add a new class: Example.java

package com.testautomation.mesaj.database.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "example")
@Data
public class Example implements Serializable {

    private static final long serialVersionUID = 6829508373480950949L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name")
    private String name;

}


> In the root folder add a folder called: resources, inside add  a folder: META-INF and create the file: persistence.xml


 <persistence-unit name="serenitybddrestinspanishtraining" transaction-type="RESOURCE_LOCAL">  (the artifact id in name)
 <class>com.testautomation.mesaj.database.entity.Example</class>  (provide the entity package path)


<persistence version="2.0"
             xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">

    <!-- Define a name used to get an entity manager. Define that you will
    complete transactions with the DB  -->
    <persistence-unit name="JEETut3" transaction-type="RESOURCE_LOCAL">

        <!-- Define the class for Hibernate which implements JPA -->
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <!-- Define the object that should be persisted in the database -->
        <class>com.testautomation.mesaj.database.entity.Example</class>
        <properties>
            <!-- Driver for DB database -->
            <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
            <!-- URL for DB -->
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost/example" />
            <!-- Username -->
            <property name="javax.persistence.jdbc.user" value="root" />
            <!-- Password -->
            <property name="javax.persistence.jdbc.password" value="my-secret-pw" />
        </properties>
    </persistence-unit>
</persistence>

> Create a package : abilities
> Inside add a class called: QueryADatabase
package com.testautomation.mesaj.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

public class QueryADatabase implements Ability {

    /**
     * Used to access the Actor's ability to QueryADatabase from within the Interaction classes, such as INSERT or DELETE
     */
    public static QueryADatabase as(Actor actor) {
        return actor.abilityTo(QueryADatabase.class);
    }

    @Override
    public String toString() {
        return "Connect to a database";
    }
}

> Insisde interactions folder add a folder: database
> Add a class called: Select
> Add another class called DatabaseInteraction that extends from Interaction
>

