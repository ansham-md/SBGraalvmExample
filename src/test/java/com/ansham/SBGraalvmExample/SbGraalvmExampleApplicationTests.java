package com.ansham.SBGraalvmExample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SbGraalvmExampleApplicationTests {

	@Test
	void contextLoads() {
		assertEquals("1","1");
	}

}
