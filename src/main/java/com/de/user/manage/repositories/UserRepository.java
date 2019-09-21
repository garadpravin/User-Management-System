package com.de.user.manage.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.de.user.manage.entities.*;




@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	@Transactional 
    @Query(value = "SELECT * FROM userdb WHERE email =?1", nativeQuery = true)
    public UserEntity getByEmail(String email);
    
}