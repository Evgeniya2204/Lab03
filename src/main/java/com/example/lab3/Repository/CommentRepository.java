package com.example.lab3.Repository;

import com.example.lab3.Entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<CommentEntity, String> {

}
