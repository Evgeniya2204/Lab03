package com.example.lab3.Repository;

import com.example.lab3.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UserEntity, String> {

}
