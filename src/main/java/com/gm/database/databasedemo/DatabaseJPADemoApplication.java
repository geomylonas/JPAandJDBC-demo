package com.gm.database.databasedemo;

import com.gm.database.databasedemo.JPA.PersonJPARepository;
import com.gm.database.databasedemo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DatabaseJPADemoApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    PersonJPARepository personJPARepository;


	public static void main(String[] args) {
		SpringApplication.run(DatabaseJPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("All Users->{}",personJPARepository.findById(10001));
		logger.info("Inserting->{}",personJPARepository.InsertInto(new Person(10005,"Takis","Manchester",new Date())));
		logger.info("Updating-{}",personJPARepository.Update(new Person(10002,"Jim updated","PALAIO FALIRO",new Date())));
		personJPARepository.DeleteById(10003);
		logger.info("All Users->{}", personJPARepository.findAll());


	/*	logger.info("query for personbooks->{}",dao2.findAll());
		logger.info("query for Georges books->{}",dao2.findByName("GEORGE"));*/
	}
}