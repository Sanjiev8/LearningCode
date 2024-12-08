package org.example.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRIES")
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

}
