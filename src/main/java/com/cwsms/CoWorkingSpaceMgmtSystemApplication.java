package com.cwsms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.cwsms.constants.SpringConstants;

//@ComponentScan(basePackages=SpringConstants.SCAN_PACKAGE_CONTROLLER)
@EntityScan(basePackages=SpringConstants.SCAN_PACKAGE_ENTITY)
//@EnableAutoConfiguration(exclude= {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
public class CoWorkingSpaceMgmtSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoWorkingSpaceMgmtSystemApplication.class, args);
	}
}
