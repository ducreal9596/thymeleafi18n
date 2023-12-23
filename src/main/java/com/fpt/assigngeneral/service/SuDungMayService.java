package com.fpt.assigngeneral.service;

import java.util.List;

import com.fpt.assigngeneral.entities.SuDungMay;

public interface SuDungMayService {
	List<SuDungMay> findAll();

	SuDungMay findOne(String maMay);

	void save(SuDungMay may);
	
	void delete(String serial);
}
