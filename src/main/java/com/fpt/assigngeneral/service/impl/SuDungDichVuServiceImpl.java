package com.fpt.assigngeneral.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpt.assigngeneral.entities.SuDungDichVu;
import com.fpt.assigngeneral.repositories.SuDungDichVuRepository;
import com.fpt.assigngeneral.service.SuDungDichVuService;

@Service
public class SuDungDichVuServiceImpl implements SuDungDichVuService {

	@Autowired
	private SuDungDichVuRepository sddvRepo;

	@Override
	public List<SuDungDichVu> findAll() {
		return sddvRepo.findAll();
	}

	@Override
	public SuDungDichVu findOne(String maSddv) {
		return sddvRepo.findById(maSddv).orElse(null);
	}

	@Override
	public void save(SuDungDichVu sddv) {
		sddvRepo.save(sddv);
	}

	@Override
	public void delete(String serial) {
		sddvRepo.deleteById(serial);
	}

}
