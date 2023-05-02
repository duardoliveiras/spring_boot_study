package edu.ardo.demo.api;

import edu.ardo.demo.model.Person;
import edu.ardo.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}

