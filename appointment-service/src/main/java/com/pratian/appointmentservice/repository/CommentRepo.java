package com.pratian.appointmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.appointmentservice.entities.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
	
	@Query(value="select c from Comment c where c.id=:id")
	public Comment getCommentById(@Param(value="id") long id);


}
