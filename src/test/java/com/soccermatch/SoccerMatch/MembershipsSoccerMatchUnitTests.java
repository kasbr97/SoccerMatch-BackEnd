package com.soccermatch.SoccerMatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

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

import com.soccermatch.SoccerMatch.entity.Memberships;
import com.soccermatch.SoccerMatch.entity.People;
import com.soccermatch.SoccerMatch.entity.Teams;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SoccerMatchApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MembershipsSoccerMatchUnitTests {

	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootURL() {
		return "http://localhost:" + port;
	}
	
	private String getMembershipsUrl() {
		return getRootURL() + "/memberships";
	}
	
	@Test
	public void contextLoads() {
	}
	
	
	//Test getAll Memberships
	@Test
	public void testGetAllMemberships() {
		
		//Given client knows the Memberships EndPoint Location
		
		
		//When client sends a Get request to /memberships EndPoint
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				getMembershipsUrl(), HttpMethod.GET, entity, String.class);
		
		//Then a Not Null response is received
		assertNotNull(response.getBody());	
	}
	
	
	
	@Test
	public void testgetMembershipsById() {
		//Given client knows the Memberships Endpoint Location
		
		//When client sends a Get request to /memberships Endpoint with an Id
		//People & Teams
		Memberships membership = new Memberships();
		Teams team = new Teams();
		People person = new People();
		
		team.setName("Equipo 1");
		team.setDescription("Descripcion para equipo 1.");
		
		person.setName("Kevin");
		person.setDni(81436977);
		person.setPhoneNumber("933436802");
		person.setEmail("kevin@gmail.com");
		person.setUsername("kevin123");
		person.setPassword("admin123");
		person.setPartner(false);
		membership.setMember_since(LocalDateTime.now());
		membership.setMember_until(LocalDateTime.now());
		membership.setRole(false);
		membership.setTeams(team);
		membership.setPerson(person);
		
		int id = membership.getId();
		Memberships membershipDuplicate = restTemplate.getForObject(getMembershipsUrl()+"/"+id, Memberships.class);
		
		//Then a Not Null response is received
		assertNotNull(membershipDuplicate);
	}
	
	@Test
	public void testCreateMemberships() {
		//Given client knows Memberships Endpoint Location
		
		//When client sends a Post request to /memberships Endpoint
		//with membership info in Resquest Body
		Memberships membership = new Memberships();
		Teams team = new Teams();
		People person = new People();
		
		team.setName("Equipo 1");
		team.setDescription("Descripcion para equipo 1.");
		
		person.setName("Kevin");
		person.setDni(81436977);
		person.setPhoneNumber("933436802");
		person.setEmail("kevin@gmail.com");
		person.setUsername("kevin123");
		person.setPassword("admin123");
		person.setPartner(false);
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
				
		membership.setTeams(team);
		membership.setPerson(person);
		membership.setMember_since(LocalDateTime.now());
		membership.setMember_until(LocalDateTime.now());
		membership.setRole(false);
		
		//Then the membership is generated
		ResponseEntity<Memberships> postResponse = restTemplate.postForEntity(
				getMembershipsUrl(), membership, Memberships.class);
		
		//And returns a Not Null response
		assertNotNull(postResponse);
	}
	
	@Test
	public void testUpdateMemberships() {
		//Given client knows Memberships Endpoint Location
		
		//When client sends a Put request to /memberships Endpoint
		//with Id value of 1 and membership info in request Body
		int id = 1;
		Memberships membership = restTemplate.getForObject(getMembershipsUrl() + id, Memberships.class);
		membership.setRole(true);
		
		
		//Then Membership info is updated
		restTemplate.put(getMembershipsUrl() + id, membership);
		Memberships updateMembership = restTemplate.getForObject(
				getMembershipsUrl() + id, Memberships.class);
		
		//And a Not Null response is received
		assertNotNull(updateMembership);
	}
	
	@Test
	public void testDeleteMembership() {
		//Given client knows Memberships Endpoint Location
		
		//When client sends a Delete request to /memberships Endpoint
		//with Id value of 2
		int id = 2;
		Memberships membership = restTemplate.getForObject(getMembershipsUrl() + id, Memberships.class);
		assertNotNull(membership);
		
		
		//Then Membership is deleted
		restTemplate.delete(getMembershipsUrl()+"/"+Long.toString(id), Memberships.class);
		try {
			membership = restTemplate.getForObject(getMembershipsUrl()+"/"+Long.toString(id), Memberships.class);
			assertNull(membership);
		} catch(final HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
		}
		
	}
	
	
	
}
