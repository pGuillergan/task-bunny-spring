package com.taskbunny.repository;

import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.taskbunny.models.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	

	@Query
	(value = "SELECT * FROM USERS WHERE USERS.role = 'client'",nativeQuery = true)
	Collection<Users> findAllActiveUsersNative();

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value="UPDATE Users SET picture = :picture WHERE userid= :id",nativeQuery = true)
	void updatePicture(@Param("id") int id,@Param("picture") byte[] picture);

	@Query
	(value = "SELECT firstname,lastname FROM Users JOIN Tasks ON Users.userid=Tasks.providerid  WHERE Users.userid = :providerid LIMIT 1",nativeQuery = true)
	Optional<Users> getProviderName(int providerid);

}
