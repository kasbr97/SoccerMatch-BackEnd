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

import com.soccermatch.SoccerMatch.entity.Payments;
import com.soccermatch.SoccerMatch.service.IPaymentsService;

@RestController
@RequestMapping("/payments")
public class PaymentsRestController {
	@Autowired
	private IPaymentsService paymentsService;
	
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Payments> > fetchAll() {
		try {
			List<Payments> Payments = paymentsService.FindAll();
			return new ResponseEntity< List<Payments> >(Payments, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Payments> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Payments > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Payments> Payments = paymentsService.findById(id);
			if(Payments.isPresent()) {
				return new ResponseEntity< Payments >(Payments.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Payments>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Payments>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Payments> save( @Valid @RequestBody Payments Payments ) {
		try {
			Payments tmp = paymentsService.Update(Payments);
			if( tmp != null ) {
				return new ResponseEntity<Payments>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Payments>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Payments>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Payments Payments ) {
		try {
			Optional<Payments> buscado = paymentsService.findById(Payments.getId());
			
			if(buscado.isPresent()) {
				paymentsService.Update(Payments);
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
			Optional<Payments> buscado = paymentsService.findById(id);
			
			if(buscado.isPresent()) {
				paymentsService.deleteById(id);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
