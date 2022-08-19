package com.ehernandez.inventory;

import com.ehernandez.inventory.utility.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = AppConfig.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
class MsvcInventoryApplicationTests {

	@Test
	void contextLoads(ApplicationContext context) {
	}

}
