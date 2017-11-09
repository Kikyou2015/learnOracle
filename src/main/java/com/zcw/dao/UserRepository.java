package com.zcw.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zcw.entity.User;

@Component
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUtId(Long utId);

	@Transactional
	@Modifying
	@Query("delete from User where utName like %:username%")
	void deleteByUsernameLike(@Param("username") String userName);
}
