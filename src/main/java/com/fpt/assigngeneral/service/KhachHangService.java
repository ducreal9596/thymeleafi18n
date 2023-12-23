package com.fpt.assigngeneral.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fpt.assigngeneral.dto.KhachHangDTO;
import com.fpt.assigngeneral.dto.KhachMayDichVuDTO;
import com.fpt.assigngeneral.entities.KhachHang;

public interface KhachHangService {
	List<KhachHangDTO> findAll();

	KhachHangDTO findOne(String makh);

	void save(KhachHangDTO kh);

	void delete(String serial);

	Page<KhachMayDichVuDTO> getInfor(Pageable pageAble, String value);

	List<KhachHang> listKhachHangSuDungDichVu();

	Page<KhachHangDTO> findAll(Pageable pageAble);
	
	Page<KhachHang> findByTenKHContaining(String keyword, Pageable pageable);
	
	long count();

	Page<KhachHangDTO> findByTen(String ten,Pageable pageable);
}
