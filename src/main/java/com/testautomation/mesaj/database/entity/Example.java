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