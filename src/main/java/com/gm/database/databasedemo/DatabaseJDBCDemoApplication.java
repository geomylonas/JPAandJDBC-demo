package com.gm.database.databasedemo;

import com.gm.database.databasedemo.entity.Person;
import com.gm.database.databasedemo.jdbc.PersonBooksDao;
import com.gm.database.databasedemo.jdbc.PersonJbdcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


import java.util.Date;

//@SpringBootApplication
public class DatabaseJDBCDemoApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJbdcDao dao;

	@Autowired
	PersonBooksDao dao2;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseJDBCDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users->{}", dao.findAll());
		logger.info("ID User->{}", dao.findById(10001));
		logger.info("numbers of row deleted={}", dao.deleteById(10002, "JIM"));
		logger.info("number of row affected={}", dao.insertInto(new Person(10004, "TAKIS", "MANCESTER", new Date())));
		logger.info("number of row affected={}", dao.updateById(new Person(10003, "SIR TAKIS", "PEIRAIAS", new Date())));
		logger.info("query for list->{}",dao.findAllList());
		logger.info("query for personbooks->{}",dao2.findAll());
		logger.info("query for Georges books->{}",dao2.findByName("GEORGE"));
	}
}