package com.fpt.assigngeneral.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fpt.assigngeneral.entities.May;

public interface MayService {
	List<May> findAll();

	May findOne(String maMay);

	void save(May may);

	void delete(String serial);

	Page<May> findAll(Pageable pageAble);
	
	Page<May> findByMaMayContaining(String keyword, Pageable pageable);
	
	long count();
}
