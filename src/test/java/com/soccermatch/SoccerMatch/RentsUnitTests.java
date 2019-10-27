package com.soccermatch.SoccerMatch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

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

import com.soccermatch.SoccerMatch.entity.Fields;
import com.soccermatch.SoccerMatch.entity.Memberships;
import com.soccermatch.SoccerMatch.entity.People;
import com.soccermatch.SoccerMatch.entity.Places;
import com.soccermatch.SoccerMatch.entity.Rents;
import com.soccermatch.SoccerMatch.entity.Teams;
import com.soccermatch.SoccerMatch.entity.Ubiquitous;








@RunWith(SpringRunner.class)
@SpringBootTest(classes = SoccerMatchApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RentsUnitTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	private String getRootUrl() {
		return "http://localhost:" + port;
	}
	
	private String getRentsUrl() {
		return getRootUrl() + "/rents";
	}
	
	private String getRentsUrlForId(long id) {
		return getRentsUrl() + "/" + Long.toString(id);
	}
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testgetAllRents() {
		//Given client knows Rents Endpoint Location
		
		//When captain sends a Get Request to /rents Endpoint
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null,headers);
		
		ResponseEntity<String> response = restTemplate.exchange(
				getRootUrl() + "/rents", HttpMethod.GET, entity, String.class);
		
		// Then a Not NUll response is received
		assertNotNull(response.getBody());
	}
	
	@Test
	public void testgetRentsById() {
		//Given client knows Rents Endpoint Location
		
		//When client sends a Get Request to /rents Endpoint with an Id
		Rents rent = restTemplate.getForObject(getRentsUrlForId(2), Rents.class);
		
		if (rent!= null) {
			System.out.println(rent.getId());
		}
		//Then a Not Null response is received
		assertNotNull(rent);
	}
	
	@Test
	public void testCreateRent() {
		//Given client knows Rents Endpoint Location
		
		//When client sends a Post Request to /rents Endpoint
		//with user info in Request Body
		Rents rent = new Rents();
		Fields field = new Fields();
		field.setId(1);
		field.setDescription("cancha test");
		field.setName("Cancha bonita");
		field.setType("Grass");
		Places place = new Places();
		place.setId(1);
		place.setDescription("canchas test");
		place.setName("Local de canchas");
		Ubiquitous ubi = new Ubiquitous();
		ubi.setId(1);
		ubi.setLatitude(-12.0431800);
		ubi.setLongitude(-77.0282400);
		ubi.setName("Lima");
		place.setUbiquitous(ubi);
		field.setPlaces(place);
		rent.setFields(field);
		rent.setDiscountPercentage(5);
		rent.setDuration(2);
		Memberships membership = new Memberships();
		membership.setId(1);
		membership.setMember_since(LocalDateTime.now());
		membership.setMember_until(LocalDateTime.now());
		membership.setRole(true);
		People person = new People();
		person.setId(1);
		person.setDni(76587555);
		person.setEmail("admin@test.com");
		person.setName("Jorge");
		person.setPartner(false);
		person.setPassword("password");
		person.setPhoneNumber("965308888");
		person.setUbiquitous(ubi);
		person.setUsername("admin");
		membership.setPerson(person);
		Teams team = new Teams();
		team.setId(1);
		team.setDescription("Equipo test");
		team.setName("Test");
		membership.setTeams(team);
		rent.setMemberships(membership);
		rent.setRentedAt(LocalDateTime.now());
		rent.setTotalPrice(90);

		
		ResponseEntity<Rents> postResponse = restTemplate.postForEntity(getRentsUrl(), rent, Rents.class);
		//Then a New rent is created
		//And a Not Null response is received
		assertNotNull(postResponse);
		//assertNotNull(postResponse.getBody());
		
	}
	
	@Test
	public void testDeleteRent() {
		int id = 2;
		Rents rent = restTemplate.getForObject(getRentsUrlForId(id), Rents.class);
		assertNotNull(rent);
		
		restTemplate.delete(getRentsUrlForId(id),Rents.class);
		try {
			rent = restTemplate.getForObject(getRentsUrlForId(id), Rents.class);
		} catch (final HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode() );
		}
	}
	
	

}
