package com.testautomation.mesaj.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "example")
@Data
@Builder
@AllArgsConstructor
public class Example implements Serializable {

    public Example(){}

    private static final long serialVersionUID = 6829508373480950949L;

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "name")
    private String name;

}
