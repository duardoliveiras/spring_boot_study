package edu.ardo.demo.dao;

import edu.ardo.demo.model.Person;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> personDelete = selectPersonById(id);
        if(personDelete.isEmpty()){
            return 0;
        }else{
            DB.remove(personDelete.get());
            return 1;
        }
    }

    @Override
    public int updatePersonById(UUID id, Person personUpdate) {
        return selectPersonById(id).map(person ->{  // com o ID procuramos a pessoa no banco
            int indexOfPersonUpdate = DB.indexOf(person);
            if (indexOfPersonUpdate >= 0){ // verificamos se essa pessoa foi encontrada no banco
                DB.set(indexOfPersonUpdate, new Person(id, personUpdate.getName())); // se ela foi encontrada, entao atualize
                return 1;
            }else{
                return 0;
            }
        }).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }


}
