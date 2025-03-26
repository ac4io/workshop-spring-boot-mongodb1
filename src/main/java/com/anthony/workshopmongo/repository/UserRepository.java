package com.anthony.workshopmongo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.anthony.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
