package edu.ardo.demo.service;

import edu.ardo.demo.dao.PersonDao;
import edu.ardo.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // essa classe e responsavel por executar a logica de negocios da aplicacao
public class PersonService {

    private final PersonDao personDao;

    @Autowired // usado para injetar automaticamente dependencias
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }
}
