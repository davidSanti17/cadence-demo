package com.nttdata.som.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

		/*
		Client client = new Client();
		String content = client.executeClient();

		//System.out.println(content);

		try {
			client.saveFile(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		*/
	}

}
