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
import com.soccermatch.SoccerMatch.service.IFieldsService;

@RestController
@RequestMapping("/fields")
public class FieldsRestController {
	@Autowired
	private IFieldsService fieldsService;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Fields> > fetchAll() {
		try {
			List<Fields> Fields = fieldsService.FindAll();
			return new ResponseEntity< List<Fields> >(Fields, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Fields> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Fields > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Fields> Fields = fieldsService.findById(id);
			if(Fields.isPresent()) {
				return new ResponseEntity< Fields >(Fields.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Fields>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Fields>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/fields/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Fields> > fetchPlaceFields(@PathVariable("id") Integer id) {
		try {
			List<Fields> Field = fieldsService.fetchPlaceFields(id);
			return new ResponseEntity< List<Fields>  >(Field, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Fields>  >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Fields> save( @Valid @RequestBody Fields Fields ) {
		try {
			Fields tmp = fieldsService.Update(Fields);
			if( tmp != null ) {
				return new ResponseEntity<Fields>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Fields>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Fields>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Fields Fields ) {
		try {
			Optional<Fields> buscado = fieldsService.findById(Fields.getId());
			
			if(buscado.isPresent()) {
				fieldsService.Update(Fields);
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
			Optional<Fields> buscado = fieldsService.findById(id);
			
			if(buscado.isPresent()) {
				fieldsService.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
