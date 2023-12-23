package com.fpt.assigngeneral.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fpt.assigngeneral.entities.May;
import com.fpt.assigngeneral.repositories.MayRepository;
import com.fpt.assigngeneral.service.MayService;

@Service
public class MayServiceImpl implements MayService {

	@Autowired
	private MayRepository mRepo;

	@Override
	public List<May> findAll() {
		return mRepo.findAll();
	}

	@Override
	public May findOne(String maMay) {
		return mRepo.findById(maMay).orElse(null);
	}

	@Override
	public void save(May may) {
		mRepo.save(may);
	}

	@Override
	public void delete(String serial) {
		mRepo.deleteById(serial);
	}

	@Override
	public Page<May> findAll(Pageable pageAble) {
		return mRepo.findAll(pageAble);
	}

	@Override
	public Page<May> findByMaMayContaining(String keyword, Pageable pageable) {
		return mRepo.findByMaMayContaining(keyword, pageable);
	}

	@Override
	public long count() {
		return mRepo.count();
	}

}
