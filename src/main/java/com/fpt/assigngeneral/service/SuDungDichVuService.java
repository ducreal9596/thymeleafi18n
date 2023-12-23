package com.fpt.assigngeneral.service;

import java.util.List;

import com.fpt.assigngeneral.entities.SuDungDichVu;

public interface SuDungDichVuService {

	List<SuDungDichVu> findAll();

	SuDungDichVu findOne(String maMay);

	void save(SuDungDichVu sddv);

	void delete(String serial);
}
