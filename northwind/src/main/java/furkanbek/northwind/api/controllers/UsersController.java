package furkanbek.northwind.api.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import furkanbek.northwind.business.abstracts.UserService;
import furkanbek.northwind.core.entities.User;
import furkanbek.northwind.core.utilities.results.DataResult;
import furkanbek.northwind.core.utilities.results.ErrorDataResult;
import furkanbek.northwind.core.utilities.results.Result;


@RestController
@RequestMapping("/api/users")
public class UsersController {

private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping("/findByEmail")
	public ResponseEntity<DataResult<User>> findByEmail(@RequestParam String email){
		return ResponseEntity.ok(this.userService.findByEmail(email));
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user){
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String,String>();
		for (var error : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(error.getField(), error.getDefaultMessage());
			
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;		
	}
	
	
}
