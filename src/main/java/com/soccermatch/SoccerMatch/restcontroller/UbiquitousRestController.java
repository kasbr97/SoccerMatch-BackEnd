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

import com.soccermatch.SoccerMatch.entity.Ubiquitous;
import com.soccermatch.SoccerMatch.service.IUbiquitousService;

@RestController
@RequestMapping("/ubiquitous")
public class UbiquitousRestController {
	@Autowired
	private IUbiquitousService ubiquitousservice;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Ubiquitous> > fetchAll() {
		try {
			List<Ubiquitous> Ubiquitous = ubiquitousservice.FindAll();
			return new ResponseEntity< List<Ubiquitous> >(Ubiquitous, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Ubiquitous> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Ubiquitous > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Ubiquitous> Ubiquitous = ubiquitousservice.findById(id);
			if(Ubiquitous.isPresent()) {
				return new ResponseEntity< Ubiquitous >(Ubiquitous.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Ubiquitous>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Ubiquitous>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Ubiquitous> save( @Valid @RequestBody Ubiquitous Ubiquitous ) {
		try {
			Ubiquitous tmp = ubiquitousservice.Update(Ubiquitous);
			if( tmp != null ) {
				return new ResponseEntity<Ubiquitous>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Ubiquitous>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Ubiquitous>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Ubiquitous Ubiquitous ) {
		try {
			Optional<Ubiquitous> buscado = ubiquitousservice.findById(Ubiquitous.getId());
			
			if(buscado.isPresent()) {
				ubiquitousservice.Update(Ubiquitous);
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
			Optional<Ubiquitous> buscado = ubiquitousservice.findById(id);
			
			if(buscado.isPresent()) {
				ubiquitousservice.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
