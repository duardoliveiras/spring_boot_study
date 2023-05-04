package edu.ardo.demo.dao;

import edu.ardo.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataBaseService implements PersonDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataBaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        String sql = "SELECT id, nome FROM person";
        List<Person> people = jdbcTemplate.query(sql, (resulSet, rowNum) -> {
            return new Person(UUID.fromString(resulSet.getString("id")), resulSet.getString("nome"));
        } );
        return people;
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        String sql = "SELECT id, nome FROM person WHERE id = ?";
        Person people = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resulSet, rowNum) -> {
            return new Person(UUID.fromString(resulSet.getString("id")), resulSet.getString("nome"));
        });
        return Optional.ofNullable(people);
    }
}
