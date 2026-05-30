package net.project.journalApp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JournalAppApplicationTests {


	@Disabled
	@Test
	 void contextLoads() {
		//just for practice that's why test is disabled.
		//also learn some default test function.
		Assertions.assertEquals(5,4+3);
	}

}
