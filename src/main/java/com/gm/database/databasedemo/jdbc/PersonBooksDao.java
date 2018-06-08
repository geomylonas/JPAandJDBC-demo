package com.gm.database.databasedemo.jdbc;

import com.gm.database.databasedemo.entity.PersonBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class PersonBooksDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    class PersonBooksMapper implements RowMapper<PersonBooks>{


        @Override
        public PersonBooks mapRow(ResultSet resultSet, int i) throws SQLException {
            PersonBooks personBooks=new PersonBooks();
            personBooks.setBook_name(resultSet.getString("BOOKS_NAME"));
            personBooks.setPerson_name(resultSet.getString("PERSON_NAME"));
            return personBooks;
        }
    }

    public List<PersonBooks> findAll(){
        return jdbcTemplate.query("SELECT BOOKS.NAME AS BOOKS_NAME, PERSON.NAME AS PERSON_NAME FROM BOOKS INNER JOIN PERSON ON PERSON.ID=BOOKS.PERSON_ID",new PersonBooksMapper());

    }

    public List<PersonBooks> findByName(String name){
        List<PersonBooks> personbooks=new ArrayList<>();
        List<Map<String,Object>> rows=jdbcTemplate.queryForList("SELECT BOOKS.NAME AS BOOKS_NAME,PERSON.NAME AS PERSON_NAME FROM BOOKS INNER JOIN PERSON ON PERSON.ID=BOOKS.PERSON_ID WHERE PERSON.NAME=?",
                new Object[]{name});
        for(Map<String,Object> row : rows){
            PersonBooks personbook=new PersonBooks();
            personbook.setBook_name((String)row.get("BOOKS_NAME"));
            personbook.setPerson_name((String)row.get("PERSON_NAME"));
            personbooks.add(personbook);
            }
        return personbooks;
    }

}