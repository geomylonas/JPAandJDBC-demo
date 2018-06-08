package com.gm.database.databasedemo.jdbc;


import com.gm.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class PersonJbdcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person=new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setLocation(resultSet.getString("location"));
            person.setBirth_date(resultSet.getDate("birth_date"));
            return person;
        }
    }

    public List<Person> findAll(){
        return jdbcTemplate.query("SELECT * FROM PERSON", new PersonRowMapper());
    }

    public Person findById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE ID=?;",new Object[]{id},new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id, String name){
        return jdbcTemplate.update("DELETE FROM PERSON WHERE ID=? AND NAME=?",new Object[]{id,name});
    }

    public int insertInto(Person person){
        return jdbcTemplate.update("INSERT INTO PERSON (ID,NAME,LOCATION,BIRTH_DATE) VALUES(?,?,?,?)",new Object[]{person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirth_date().getTime())});
    }

    public int updateById(Person person){
        return jdbcTemplate.update("UPDATE PERSON SET NAME=?,LOCATION=?,BIRTH_DATE=? WHERE ID=?",new Object[]{person.getName(),person.getLocation(),person.getBirth_date(),person.getId()});
    }

    public List<Person> findAllList(){
        List<Person> persons=new ArrayList<>();
        List<Map<String,Object>> rows=jdbcTemplate.queryForList("SELECT * FROM PERSON");
        for(Map<String,Object> row : rows){
            Person person=new Person();
            person.setId((int)row.get("id"));
            person.setName((String)row.get("name"));
            person.setLocation((String)row.get("location"));
            person.setBirth_date((Date)row.get("birth_date"));
            persons.add(person);
        }
        return persons;


    }

}

