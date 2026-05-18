package com.todolist.list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.list.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	

}
