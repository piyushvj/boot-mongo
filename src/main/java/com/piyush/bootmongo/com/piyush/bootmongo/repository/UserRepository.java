package com.piyush.bootmongo.com.piyush.bootmongo.repository;

import com.piyush.bootmongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
