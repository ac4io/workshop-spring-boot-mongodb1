package com.anthony.workshopmongo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthony.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User anthonny = new User("1", "Anthonny", "anthonnycaiolima@gmail.com");
		User flavia = new User("2", "Flavia", "flavia@gmail.com");
		
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(anthonny,flavia));
		return ResponseEntity.ok().body(list);
	}
}
