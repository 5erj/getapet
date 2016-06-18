package controller;

import org.springframework.beans.factory.annotation.Autowired;
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
		pet.setResourceId(counterService.getNextSequence("pet"));
		repository.save(pet);
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value= "/{petId}", 
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, 
							MediaType.APPLICATION_JSON_VALUE})
	public Pet getPetById(@PathVariable Long petId) {
	    return repository.findOne(petId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value= "/{petId}")
	public ResponseEntity<?> deletePetById(@PathVariable Long petId) {
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
    	org.springframework.web.bind.MethodArgumentNotValidException.class
    )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ErrorResponseBody httpBadRequestHandler(MethodArgumentNotValidException ex) {
        return new ErrorResponseBody(ex.getMessage());
    }
}
