package com.anthony.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anthony.workshopmongo.domain.User;
import com.anthony.workshopmongo.dto.UserDTO;
import com.anthony.workshopmongo.repository.UserRepository;
import com.anthony.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		User user = repo.findById(id).orElseThrow(() -> 
		new ObjectNotFoundException("Objeto não encontrado!"));
		return user;
	}
	public User insert(User obj) {
		return repo.insert(obj);
	}
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
