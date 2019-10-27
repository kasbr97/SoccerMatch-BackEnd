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

import com.soccermatch.SoccerMatch.entity.Teams;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SoccerMatchApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TeamsUnitTests {
	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	private String getTeamsUrl() {
		return getRootUrl()+"/teams";
	}
	private String getTeamsUrlForId(long id) {
		return getTeamsUrl()+"/"+Long.toString(id);
	}
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testCreateTeam() {
		Teams team=new Teams();
		team.setDescription("Nuevo equipo de prueba");
		team.setName("Nuevo Equipo");
		ResponseEntity<Teams> postResponse=restTemplate.postForEntity(getTeamsUrl(),team,Teams.class);	
		assertNotNull(postResponse);
	}
	
	@Test
	public void testFetchAll() {
		HttpHeaders headers=new HttpHeaders();
		HttpEntity<String> entity=new HttpEntity<String>(null,headers);
		ResponseEntity<String> response=restTemplate.exchange(getTeamsUrl(),HttpMethod.GET,entity,String.class);
		assertNotNull(response.getBody());
	}
	@Test
	public void testFetchById() {
		Teams team=restTemplate.getForObject(getTeamsUrlForId(1), Teams.class);
		//System.out.println(team.getName());
		assertNotNull(team);
	}
	
	
	@Test
	public void testUpdate() {
		Teams team=restTemplate.getForObject(getTeamsUrlForId(1), Teams.class);
		team.setDescription("Los expertos en la materia");
		team.setName("Equipo Capo");
		restTemplate.put(getTeamsUrlForId(1), team);
		Teams updateTeam=restTemplate.getForObject(getTeamsUrlForId(1),Teams.class);	
	}
	
	
	@Test
	public void testDelete() {
		Teams team=restTemplate.getForObject(getTeamsUrlForId(1), Teams.class);
		assertNotNull(team);
		restTemplate.delete(getTeamsUrlForId(1),Teams.class);
		try {
			team=restTemplate.getForObject(getTeamsUrlForId(1), Teams.class);
		}
		catch(final HttpClientErrorException e) {
			assertEquals(HttpStatus.NOT_FOUND,e.getStatusCode());
		}
	}
}
