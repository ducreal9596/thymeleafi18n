package com.fpt.assigngeneral.repositories;


import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpt.assigngeneral.entities.KhachHang;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Serializable> {
	Page<KhachHang> findBySuDungDichVuIsNotNull(Pageable pageable);

	Page<KhachHang> findByTenKHContainingAndSuDungDichVuIsNotNull(String keyword, Pageable pageable);

	Page<KhachHang> findByTenKHContaining(String keyword, Pageable pageable);

	long count();
}
