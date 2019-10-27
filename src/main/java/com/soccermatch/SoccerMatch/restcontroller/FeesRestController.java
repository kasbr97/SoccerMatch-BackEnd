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

import com.soccermatch.SoccerMatch.entity.Fees;
import com.soccermatch.SoccerMatch.service.IFeesService;

@RestController
@RequestMapping("/fees")
public class FeesRestController {
	@Autowired
	private IFeesService feesService;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Fees> > fetchAll() {
		try {
			List<Fees> Fees = feesService.FindAll();
			return new ResponseEntity< List<Fees> >(Fees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Fees> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Fees > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Fees> Fees = feesService.findById(id);
			if(Fees.isPresent()) {
				return new ResponseEntity< Fees >(Fees.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Fees>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Fees>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Fees> save( @Valid @RequestBody Fees Fees ) {
		try {
			Fees tmp = feesService.Update(Fees);
			if( tmp != null ) {
				return new ResponseEntity<Fees>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Fees>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Fees>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Fees Fees ) {
		try {
			Optional<Fees> buscado = feesService.findById(Fees.getId());
			
			if(buscado.isPresent()) {
				feesService.Update(Fees);
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
			Optional<Fees> buscado = feesService.findById(id);
			
			if(buscado.isPresent()) {
				feesService.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
