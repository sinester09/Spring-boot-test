package com.users.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.users.model.Phone;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long > {

	public Set<Phone> findByNumber(String number);
	public Set<Phone> findByCitycode(String citycode);
	public Set<Phone> findByCountrycode(String countrycode);
}
