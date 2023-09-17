package com.crashtech.hm_mgt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HmMgtApplication {

	public static void main(String[] args) {
		String PORT = System.getenv("PORT");
		SpringApplication.run(HmMgtApplication.class, args);
	}

}
