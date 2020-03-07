package com.org.mail.dao;

import java.io.Serializable;

import com.org.mail.entity.UserEntity;

public interface UserDAO {

	public Serializable save(UserEntity entity);
	
}
