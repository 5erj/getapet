package controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import error.ErrorResponseBody;
import repository.PetRepository;
import representation.Pet;
import service.CounterService;

@RestController
@RequestMapping("/pet")
public class PetController {
	
	@Autowired
	private CounterService counterService;
	
	@Autowired
	private PetRepository repository;
	
	@RequestMapping(method = RequestMethod.POST, 
			consumes= {MediaType.APPLICATION_JSON_UTF8_VALUE, 
							MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> addPet(@RequestBody @Validated Pet pet) {
		long resourceId = counterService.getNextSequence("pet");
		pet.setResourceId(resourceId);
		repository.save(pet);
		
		// Return resource URL in location header
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{petId}")
				.buildAndExpand(resourceId).toUri());
		
	    return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/{petId}", 
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, 
							MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Pet> getPetById(@PathVariable Long petId) {
	    Pet pet = repository.findOne(petId);
	    if (pet == null) {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    
	    return new ResponseEntity<Pet>(pet, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/{petId}")
	public ResponseEntity<?> deletePetById(@PathVariable Long petId) {
		Pet pet = repository.findOne(petId);
		if (pet == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		repository.delete(petId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}


/**
 * This class is to send custom errors to the caller when an exception is 
 * raised from inside the controller methods
 *
 */
@ControllerAdvice
class PetControllerAdvice {

    @ResponseBody
    @ExceptionHandler(
    	{
    		org.springframework.web.bind.MethodArgumentNotValidException.class,
    		org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class
    	}
    )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponseBody httpBadRequestHandler(Exception ex) {
        return new ErrorResponseBody(ex.getMessage());
    }
}
