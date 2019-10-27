package com.soccermatch.SoccerMatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.soccermatch.SoccerMatch.entity.People;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = SoccerMatchApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PeopleSoccerMatchUnitTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootURL() {
		return "http://localhost:" + port;
	}
	
	private String getPeopleUrl() {
		return getRootURL() + "/people";
	}
	
	@Test
	public void contextLoads() {
	}
	
	//Test getAll People
		@Test
		public void testGetAllPeople() {
			
			//Given client knows the People EndPoint Location
			
			
			//When client sends a Get request to /people EndPoint
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);
			
			ResponseEntity<String> response = restTemplate.exchange(
					getPeopleUrl(), HttpMethod.GET, entity, String.class);
			
			//Then a Not Null response is received
			assertNotNull(response.getBody());	
		}
		
		@Test
		public void testgetPeopleById() {
			//Given client knows the People Endpoint Location
			
			//When client sends a Get request to /people Endpoint with an Id
			int id = 12;
			People person = restTemplate.getForObject(getPeopleUrl()+"/"+id, People.class);
			//System.out.println(person.getName());
			
			//Then a Not Null response is received
			assertNotNull(person);
		}
		
		@Test
		public void testCreatePeople() {
			//Given client knows People Endpoint Location
			
			//When client sends a Post request to /people Endpoint
			//with person info in Resquest Body
			People person = new People();
			
			person.setName("Kevin");
			person.setDni(81436977);
			person.setPhoneNumber("933436802");
			person.setEmail("kevin@gmail.com");
			person.setUsername("kevin123");
			person.setPassword("admin123");
			person.setPartner(false);
			
			//Then a New Person is created 
			ResponseEntity<People> postResponse = restTemplate.postForEntity(
					getPeopleUrl(), person, People.class);
			
			//And a Not Null response is received
			assertNotNull(postResponse);
		
		}
		
		
		@Test
		public void testUpdatePeople() {
			//Given client knows People Endpoint Location
			
			//When client sends a Put request to /people Endpoint
			//with Id value of 1 and user info in request Body
			int id = 1;
			People person = restTemplate.getForObject(getPeopleUrl() + id, People.class);
			person.setName("Antonio");
			
			
			//Then the person info is updated
			restTemplate.put(getPeopleUrl() + id, person);
			People updatePerson = restTemplate.getForObject(
					getPeopleUrl() + id, People.class);
			
			//And a Not Null response is received
			assertNotNull(updatePerson);
		}
		
		
		@Test
		public void testDeletePeople() {
			//Given client knows People Endpoint Location
			
			//When client sends a Delete request to /people Endpoint
			//with Id value of 2
			int id = 2;
			People person = restTemplate.getForObject(getPeopleUrl() + id, People.class);
			assertNotNull(person);
			
			
			//Then the person is deleted
			restTemplate.delete(getPeopleUrl()+"/"+Long.toString(id), People.class);
			try {
				person = restTemplate.getForObject(getPeopleUrl()+"/"+Long.toString(id), People.class);
			} catch(final HttpClientErrorException e) {
				assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
			}
			
		}
		
}
