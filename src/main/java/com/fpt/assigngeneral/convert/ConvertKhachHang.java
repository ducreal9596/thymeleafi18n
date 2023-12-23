package com.fpt.assigngeneral.convert;


import org.springframework.stereotype.Component;

import com.fpt.assigngeneral.dto.KhachHangDTO;
import com.fpt.assigngeneral.entities.KhachHang;

@Component
public class ConvertKhachHang {
	public KhachHangDTO fromKhachHang(KhachHang khachHang) {
		KhachHangDTO khachHangDTO = new KhachHangDTO();
		khachHangDTO.setMaKH(khachHang.getMaKH());
		khachHangDTO.setTenKH(khachHang.getTenKH());
		khachHangDTO.setDiaChi(khachHang.getDiaChi());
		khachHangDTO.setSoDienThoai(khachHang.getSoDienThoai());
		khachHangDTO.setEmail(khachHang.getEmail());

		return khachHangDTO;
	}

	public KhachHang toKhachHang(KhachHangDTO khDto) {
		KhachHang khachHang = new KhachHang();
		khachHang.setMaKH(khDto.getMaKH());
		khachHang.setTenKH(khDto.getTenKH());
		khachHang.setDiaChi(khDto.getDiaChi());
		khachHang.setSoDienThoai(khDto.getSoDienThoai());
		khachHang.setEmail(khDto.getEmail());

		return khachHang;
	}
}
