package com.employee.registration;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientOptions.Builder;
import com.mongodb.ServerAddress;

@SpringBootApplication
@Configuration
public class UserRegistrationApplication {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
	}


	@Value("${db.host}")
	String HOST;

	@Value("${db.port}")
	Integer PORT;

	@Value("${db.name}")
	String DATABASE;

	
	@Bean
	public Datastore getDataStore() {
		logger.info("Start-getDataStore");
		System.out.println("Ends-getDataStore");
		Morphia morphia = new Morphia();
		Builder b = MongoClientOptions.builder();
		b.connectTimeout(150000);
		b.serverSelectionTimeout(150000);
		b.socketKeepAlive(true);
		ServerAddress serverAddress = new ServerAddress(HOST, PORT);
		MongoClient client = new MongoClient(serverAddress, b.build());
		Datastore dataStore = morphia.createDatastore(client, DATABASE);
		logger.info("Databse Name :"+DATABASE+" "+"Host:"+HOST +" "+"Port :"+PORT+""+"DataStore:"+dataStore);
		System.out.println("Databse Name :"+DATABASE+" "+"Host:"+HOST +" "+"Port :"+PORT+""+"DataStore:"+dataStore);
		dataStore.ensureIndexes();
		System.out.println("Ends-getDataStore");
		logger.info("Ends-getDataStore");
		return dataStore;
	}
}
