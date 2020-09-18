package com.zemoso.blogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zemoso.blogservice.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
