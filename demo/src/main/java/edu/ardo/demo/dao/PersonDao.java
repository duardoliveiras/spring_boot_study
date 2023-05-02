package edu.ardo.demo.dao;

import edu.ardo.demo.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao { // Data Access Object

    int insertPerson(UUID id, Person person); // metodo abstrato para inserir uma pessoa no banco

    default int insertPerson(Person person){ // metodo para inserir uma pessoa sem ID, gerando um aleatoriamente
        UUID id = UUID.randomUUID();      // tipo default para as classes filhas nao precisarem implementar
        return insertPerson(id, person);
    }
    List<Person> selectAllPeople();
}
