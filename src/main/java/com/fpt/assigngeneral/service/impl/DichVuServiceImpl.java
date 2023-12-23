package com.fpt.assigngeneral.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fpt.assigngeneral.entities.DichVu;
import com.fpt.assigngeneral.repositories.DichVuRepository;
import com.fpt.assigngeneral.service.DichVuService;

@Service
public class DichVuServiceImpl implements DichVuService {

	@Autowired
	private DichVuRepository dvRepo;

	@Override
	public List<DichVu> findAll() {
		return dvRepo.findAll();
	}

	@Override
	public DichVu findOne(String maDV) {
			Optional<DichVu> optionalDichVu = dvRepo.findById(maDV);
			return optionalDichVu.orElse(null); 
	}
	

	@Override
	public void save(DichVu dv) {
		dvRepo.save(dv);
	}

	@Override
	public void delete(String serial) {
		dvRepo.deleteById(serial);
	}

	@Override
	public Page<DichVu> findAll(Pageable pageAble) {
		return dvRepo.findAll(pageAble);
	}

	@Override
	public Page<DichVu> findByTenDVContaining(String keyword, Pageable pageable) {
		return dvRepo.findByTenDVContaining(keyword, pageable);
	}

	@Override
	public long count() {
		return dvRepo.count();
	}

}
