package com.zcw.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.zcw.entity.User;

@Component
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUtId(Long utId);
}
