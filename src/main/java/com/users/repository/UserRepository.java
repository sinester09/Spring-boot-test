package com.users.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.users.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

	public Iterable<User> findByName(String name);
	public Iterable<User> findAllByIsActive(boolean status);
	public Iterable<User> findByEmail(String email);
}
