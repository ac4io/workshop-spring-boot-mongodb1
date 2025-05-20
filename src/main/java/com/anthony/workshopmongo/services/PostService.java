package com.anthony.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anthony.workshopmongo.domain.Post;
import com.anthony.workshopmongo.repository.PostRepository;
import com.anthony.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Post user = repo.findById(id).orElseThrow(() -> 
		new ObjectNotFoundException("Objeto não encontrado!"));
		return user;
	}
	public List<Post> findByTitle(String text){
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
