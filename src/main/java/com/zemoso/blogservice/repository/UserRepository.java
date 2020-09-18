package com.zemoso.blogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zemoso.blogservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query(nativeQuery = true, value="select count(*) from bloguser where user_name=?1")
	Long getUserIdOfUserByUserName(String user_name);
	
	
}
