package com.zemoso.blogservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zemoso.blogservice.model.FollowUserMap;

@Repository
public interface FollowUserMapRepository extends JpaRepository<FollowUserMap, Long> {

}
