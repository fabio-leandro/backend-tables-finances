package com.fabio.backend;

import com.fabio.backend.models.Financing;
import com.fabio.backend.models.enums.RateType;
import com.fabio.backend.models.enums.Table;
import com.fabio.backend.services.FinancingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);

	}

}
