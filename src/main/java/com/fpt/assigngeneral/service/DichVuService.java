package com.fpt.assigngeneral.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fpt.assigngeneral.entities.DichVu;

public interface DichVuService {
	List<DichVu> findAll();

	DichVu findOne(String maDV);

	void save(DichVu kh);

	void delete(String serial);

	Page<DichVu> findAll(Pageable pageAble);

	Page<DichVu> findByTenDVContaining(String keyword, Pageable pageable);
	
	long count();
}
