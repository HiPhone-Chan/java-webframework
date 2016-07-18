package com.chf.spring.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chf.spring.domain.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

}
