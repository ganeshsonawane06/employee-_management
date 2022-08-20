package com.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Country;

@Repository
public interface CountryRepo extends CrudRepository<Country, Long> {

}
