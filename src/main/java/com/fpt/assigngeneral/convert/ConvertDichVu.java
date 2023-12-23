package com.fpt.assigngeneral.convert;


import com.fpt.assigngeneral.dto.DichVuDTO;
import com.fpt.assigngeneral.entities.DichVu;

public class ConvertDichVu {
	public DichVuDTO fromEntity(DichVu dichVu) {
		DichVuDTO dto = new DichVuDTO();
		dto.setMaDV(dichVu.getMaDV());
		dto.setTenDV(dichVu.getTenDV());
		dto.setDonViTinh(dichVu.getDonViTinh());
		dto.setDonGia(dichVu.getDonGia());
		return dto;
	}

	public DichVu toEntity(DichVuDTO dvDTO) {
		DichVu dichVu = new DichVu();
		dichVu.setMaDV(dvDTO.getMaDV());
		dichVu.setTenDV(dvDTO.getTenDV());
		dichVu.setDonViTinh(dvDTO.getDonViTinh());
		dichVu.setDonGia(dvDTO.getDonGia());
		return dichVu;
	}
}
