package edu.ardo.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {

    private final UUID id; // indicador unico universal
                          // garante que a probabilidade de gerar dois IDs identicos e quase nula
    private final String name;


    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) { // JsonProperty e usado para associar um nome de um JSON a um atributo em uma classe
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
