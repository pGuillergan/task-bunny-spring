package com.taskbunny.repository;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import com.taskbunny.models.Tasks;
import com.taskbunny.models.Users;

public interface TasksRepository extends JpaRepository<Tasks, Integer>{
	
	@Query
	(value = "SELECT * FROM Tasks WHERE Tasks.category = :category",nativeQuery = true)
	Collection<Tasks> findAllTaskCategories(@Param("category") String category);
	
	@Query
	(value = "SELECT * FROM Tasks WHERE Tasks.clientid = :clientid",nativeQuery = true)
	Collection<Tasks> findAllTaskByClientID(@Param("clientid") int clientid);
	
	@Query
	(value = "SELECT * FROM Tasks WHERE Tasks.providerid = :providerid",nativeQuery = true)
	Collection<Tasks> findAllTaskByProviderID(@Param("providerid") int providerid);
	
	@Query
	(value = "SELECT sum(amountpaid) FROM Tasks WHERE Tasks.providerid = :providerid",nativeQuery = true)
	double totalEarnings(@Param("providerid") String providerid);
	

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value="UPDATE Tasks SET status= :status WHERE taskid = :taskid",nativeQuery = true)
	 void updateStatus(@Param("taskid") int tasksid,@Param("status") String status);

	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value="UPDATE Tasks SET providerid= :providerid WHERE taskid = :taskid",nativeQuery = true)
	void updateProviderID(@Param("taskid") int taskid,@Param("providerid") int providerid);
	
	@Transactional
    @Modifying
    @Query(value = "delete from Tasks where taskid = :taskid",nativeQuery = true)
	void deleteByTaskID(@Param("taskid") int id);
	
	@Query
	(value = "SELECT count(taskid) FROM Tasks WHERE Tasks.providerid = :providerid",nativeQuery = true)
	int getTotalTasksForAProvider(@Param("providerid") int providerid);
	

	//join tasks and users by clientID and ProviderID----
	//get, post for banktransfers
	//get by clientid and providerid for ratings
	//delete tasks, users 
}
