package com.codeial.codeial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeial.codeial.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>{
	PostEntity findById(long id); //findById is in-built
}
