package com.anthony.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.anthony.workshopmongo.domain.Post;
import com.anthony.workshopmongo.domain.User;
import com.anthony.workshopmongo.dto.AuthorDTO;
import com.anthony.workshopmongo.repository.PostRepository;
import com.anthony.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("02/04/2025"), "O vasco empatou ontem","O vasco empatou ontem por culpa de Carille",new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("03/04/2025"), "Estou conseguindo estudar", "Estou conseguindo estudar Spring boot", new AuthorDTO(maria));
		
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));		
		userRepository.save(maria);
	}
	
}
