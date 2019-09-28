package com.soccermatch.SoccerMatch.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soccermatch.SoccerMatch.entity.Teams;
import com.soccermatch.SoccerMatch.service.ITeamsService;

@RestController
@RequestMapping("/teams")
public class TeamsRestController {
	@Autowired
	private ITeamsService teamsservice;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Teams> > fetchAll() {
		try {
			List<Teams> Teams = teamsservice.FindAll();
			return new ResponseEntity< List<Teams> >(Teams, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Teams> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Teams > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Teams> Teams = teamsservice.findById(id);
			if(Teams.isPresent()) {
				return new ResponseEntity< Teams >(Teams.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Teams>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Teams>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/people/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Teams> > fetchTeamsById(@PathVariable("id") Integer id) {
		try {
			Optional<List<Teams>> Teams = teamsservice.fetchTeamsByUsers(id);
			if(Teams.isPresent()) {
				return new ResponseEntity< List<Teams>  >(Teams.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Teams> >(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Teams>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Teams> save( @Valid @RequestBody Teams Teams ) {
		try {
			Teams tmp = teamsservice.Update(Teams);
			if( tmp != null ) {
				return new ResponseEntity<Teams>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Teams>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Teams>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Teams Teams ) {
		try {
			Optional<Teams> buscado = teamsservice.findById(Teams.getId());
			
			if(buscado.isPresent()) {
				teamsservice.Update(Teams);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping( value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> delete( @PathVariable("id") Integer id ) {
		try {
			Optional<Teams> buscado = teamsservice.findById(id);
			
			if(buscado.isPresent()) {
				teamsservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
