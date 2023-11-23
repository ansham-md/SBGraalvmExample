package com.ansham.SBGraalvmExample;

import com.ansham.SBGraalvmExample.model.DPRequest;
import com.ansham.SBGraalvmExample.repository.DomesticPaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SbGraalvmExampleApplication {

	@Autowired
	DomesticPaymentsRepository domesticPaymentsRepository;

	@RequestMapping("/")
	DPRequest home(){
		DPRequest dpr=new DPRequest(123L,"paytm");
		domesticPaymentsRepository.save(dpr);

		return domesticPaymentsRepository.findByConsentid(123L);
	}

	public static void main(String[] args) {
		SpringApplication.run(SbGraalvmExampleApplication.class, args);
	}

}
