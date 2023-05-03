package edu.ardo.demo.api;

import com.sun.jdi.event.ExceptionEvent;
import edu.ardo.demo.model.Person;
import edu.ardo.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController // indica que os metodos dessa classe sao responsaveis por manipular solicitacoes http e retornar json ou xml
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping // usado para mapear solicitacoes http post, o metodo e executado sempre que uma solicitacao post for feita
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }   // @ResquestBody e usado quando os dados sao trasmitidos como json no corpo da solicitacao http

    @GetMapping // usado para mapear o metodo de retorno GET
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }


    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable("id") UUID id){
        return personService.deletePerson(id);
    }
    @PutMapping(path = "{id}")
    public int updatePersonById(@PathVariable("id") UUID id, @RequestBody Person personUpdate){
        return personService.updatePerson(id, personUpdate);
    }

}

