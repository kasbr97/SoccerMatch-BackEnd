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

import com.soccermatch.SoccerMatch.entity.Rents;
import com.soccermatch.SoccerMatch.service.IRentsService;

@RestController
@RequestMapping("/rents")
public class RentsRestController {
	@Autowired
	private IRentsService rentsService;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Rents> > fetchAll() {
		try {
			List<Rents> Rents = rentsService.FindAll();
			return new ResponseEntity< List<Rents> >(Rents, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Rents> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Rents > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Rents> Rents = rentsService.findById(id);
			if(Rents.isPresent()) {
				return new ResponseEntity< Rents >(Rents.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Rents>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Rents>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Rents> save( @Valid @RequestBody Rents Rents ) {
		try {
			Rents tmp = rentsService.Update(Rents);
			if( tmp != null ) {
				return new ResponseEntity<Rents>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Rents>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Rents>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Rents Rents ) {
		try {
			Optional<Rents> buscado = rentsService.findById(Rents.getId());
			
			if(buscado.isPresent()) {
				rentsService.Update(Rents);
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
			Optional<Rents> buscado = rentsService.findById(id);
			
			if(buscado.isPresent()) {
				rentsService.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
