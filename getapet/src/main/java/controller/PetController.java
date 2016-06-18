package controller;

import java.net.MalformedURLException;
import java.net.URL;

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

import com.fasterxml.jackson.databind.util.JSONWrappedObject;

import error.ErrorResponseBody;
import representation.Category;
import representation.Pet;
import representation.Tag;

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
	
	@RequestMapping(method = RequestMethod.GET, value= "/{petId}", 
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE, 
							MediaType.APPLICATION_JSON_VALUE})
	public Pet getPetById(@PathVariable String petId) {
	    System.out.println("Retrieved a pet with id: " + petId);
	    URL[] photoUrls = new URL[1];
	    try {
	    	photoUrls[0] = new URL("http://test.com");
	    } catch (MalformedURLException e){
	    	e.printStackTrace();
		}
		Tag[] tags = {new Tag(0, "bulldog")};
	    return new Pet(0, new Category(0, "dog"), 
				"max", photoUrls, tags, "available");
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
