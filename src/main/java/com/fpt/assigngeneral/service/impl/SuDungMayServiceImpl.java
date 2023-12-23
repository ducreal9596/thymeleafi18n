package com.fpt.assigngeneral.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.assigngeneral.entities.SuDungMay;
import com.fpt.assigngeneral.repositories.SuDungMayRepository;
import com.fpt.assigngeneral.service.SuDungMayService;

@Service
public class SuDungMayServiceImpl implements SuDungMayService {

	@Autowired
	private SuDungMayRepository sdRepo;

	@Override
	public List<SuDungMay> findAll() {
		return sdRepo.findAll();
	}

	@Override
	public SuDungMay findOne(String maMay) {
		return sdRepo.findById(maMay).orElse(null);
	}

	@Override
	public void save(SuDungMay sd) {
		sdRepo.save(sd);
	}

	@Override
	public void delete(String serial) {
		sdRepo.deleteById(serial);
	}

}
