package com.malgn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malgn.entity.Content;

public interface ContentRepository extends JpaRepository<Content, Long>{
	
}
