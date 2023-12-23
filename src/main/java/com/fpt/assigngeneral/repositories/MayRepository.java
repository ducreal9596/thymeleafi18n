package com.fpt.assigngeneral.repositories;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpt.assigngeneral.entities.May;

@Repository
public interface MayRepository extends JpaRepository<May, Serializable> {
	Page<May> findByMaMayContaining(String keyword, Pageable pageable);
	
	long count();
}
