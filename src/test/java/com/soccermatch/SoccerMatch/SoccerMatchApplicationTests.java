package com.soccermatch.SoccerMatch;
import static org.junit.Assert.assertNotNull;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes=DemoApplication.class,webEnvironment=SpringBootTest.webEnviroment.RANDOM_PORT)
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.soccermatch.SoccerMatch.entity.Teams;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SoccerMatchApplicationTests {
	@Test
	public void contextLoads() {
	}


}
