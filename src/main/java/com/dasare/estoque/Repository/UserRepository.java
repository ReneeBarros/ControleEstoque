package com.dasare.estoque.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import com.dasare.estoque.model.security.User;

public interface UserRepository extends JpaRepositoryImplementation<User, Long> {
	
	
	@Query("SELECT u FROM User WHERE u.uuserName =:userName")
	User findByUsername(@Param("userName") String userName);
	

}
