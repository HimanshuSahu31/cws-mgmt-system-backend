package com.cwsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cwsms.constants.SpringConstants;

@ComponentScan(basePackages = {SpringConstants.SCAN_BASE_PACKAGE})
@SpringBootApplication
public class CoWorkingSpaceMgmtSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoWorkingSpaceMgmtSystemApplication.class, args);
	}
}
