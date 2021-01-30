package org.mpaauw.merlin;

import org.mpaauw.merlin.query.QueryService;
import org.mpaauw.merlin.query.QueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MerlinApplication {

	private static QueryService queryService = new QueryServiceImpl();

	public static void main(String[] args) {
		SpringApplication.run(MerlinApplication.class, args);
		try {
			doThing();
		} catch(Exception ex) {
			System.out.println("Error at main.");
		}
	}

	private static void doThing() throws IOException {
		queryService.GetLastTradePrice("pizza");
	}

}
