package com.fpt.assigngeneral.repositories;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpt.assigngeneral.entities.DichVu;

@Repository
public interface DichVuRepository extends JpaRepository<DichVu, Serializable> {
	Page<DichVu> findByTenDVContaining(String keyword, Pageable pageable);
}
