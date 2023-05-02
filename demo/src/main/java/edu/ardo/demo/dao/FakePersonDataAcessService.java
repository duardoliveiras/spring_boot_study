package edu.ardo.demo.dao;

import edu.ardo.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao") // define essa classe como repositorio, responsavel por interagir com o banco de dados
public class FakePersonDataAcessService implements  PersonDao { // metodo fake para inserir pessoas no banco

    private static List<Person> DB = new ArrayList<>(); // lista de pessoas

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName())); // adiciona a pessoa numa lista
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }


}
