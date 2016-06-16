package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import representation.Pet;

@RestController
@RequestMapping("/pet")
public class PetController {
	
	@RequestMapping(method = RequestMethod.POST, 
			consumes= {MediaType.APPLICATION_JSON_UTF8_VALUE, 
							MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> addPet(@RequestBody @Validated Pet pet) {
	    System.out.println("Added a pet with name: " + pet.getName());
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
