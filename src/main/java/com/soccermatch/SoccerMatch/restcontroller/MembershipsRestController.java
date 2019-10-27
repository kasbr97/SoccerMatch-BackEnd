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

import com.soccermatch.SoccerMatch.entity.Fields;
import com.soccermatch.SoccerMatch.entity.Memberships;
import com.soccermatch.SoccerMatch.entity.People;
import com.soccermatch.SoccerMatch.service.IMembershipsService;

@RestController
@RequestMapping("/memberships")
public class MembershipsRestController {
	@Autowired
	private IMembershipsService membershipsService;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Memberships> > fetchAll() {
		try {
			List<Memberships> Memberships = membershipsService.FindAll();
			return new ResponseEntity< List<Memberships> >(Memberships, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Memberships> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Memberships > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Memberships> Memberships = membershipsService.findById(id);
			if(Memberships.isPresent()) {
				return new ResponseEntity< Memberships >(Memberships.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Memberships>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Memberships>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Memberships> save( @Valid @RequestBody Memberships Memberships ) {
		try {
			Memberships tmp = membershipsService.Update(Memberships);
			if( tmp != null ) {
				ResponseEntity<Memberships> response = new ResponseEntity<Memberships>(HttpStatus.OK);
				return response.ok(tmp);
				//return new ResponseEntity<Memberships>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Memberships>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Memberships>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Memberships Memberships ) {
		try {
			Optional<Memberships> buscado = membershipsService.findById(Memberships.getId());
			
			if(buscado.isPresent()) {
				membershipsService.Update(Memberships);
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
			Optional<Memberships> buscado = membershipsService.findById(id);
			
			if(buscado.isPresent()) {
				membershipsService.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
