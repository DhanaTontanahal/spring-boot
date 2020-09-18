package com.zemoso.blogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zemoso.blogservice.model.Blog;

@Repository
public interface BlogReposit extends JpaRepository<Blog,Long>{


}
