package com.digging.gingstagram.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.digging.gingstagram.user.domain.User;

@Mapper
public interface UserRepository {

	public int insertUser(
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("name") String name
			, @Param("email") String email);

	public User selectUser(
			@Param("loginId") String loginId
			, @Param("password") String password);
	
	public User searchId(@Param("loginId") String loginId);
}
