package com.employee.repository;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
//	@Query("SELECT user_name, password, first_name, last_name, status FROM user WHERE user_name = :userName")
	public User getUserByUserName(@Param(value = "userName") String userName);
	public User getUserByEmail(@Param(value = "email") String email);
}
