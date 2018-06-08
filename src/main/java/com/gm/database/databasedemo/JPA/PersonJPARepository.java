package com.gm.database.databasedemo.JPA;

import com.gm.database.databasedemo.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import java.util.List;
@Transactional
@Repository
public class PersonJPARepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }

    public Person InsertInto(Person person){
        return entityManager.merge(person);
    }

    public Person Update(Person person){
        return entityManager.merge(person);
    }

    public void DeleteById(int id){
        Person person=findById(id);
        entityManager.remove(person);
    }

    public List<Person> findAll(){
        TypedQuery<Person> findAllPersons=entityManager.createNamedQuery("find all",Person.class);
        return findAllPersons.getResultList();
    }
}
