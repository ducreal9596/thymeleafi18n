package com.fpt.assigngeneral.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fpt.assigngeneral.convert.ConvertKhachHang;
import com.fpt.assigngeneral.dto.KhachHangDTO;
import com.fpt.assigngeneral.dto.KhachMayDichVuDTO;
import com.fpt.assigngeneral.entities.KhachHang;
import com.fpt.assigngeneral.entities.SuDungDichVu;
import com.fpt.assigngeneral.entities.SuDungMay;
import com.fpt.assigngeneral.repositories.KhachHangRepository;
import com.fpt.assigngeneral.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService {

	@Autowired
	private KhachHangRepository khRepo;

	@Autowired
	private ConvertKhachHang conver;

	@Override
	public List<KhachHangDTO> findAll() {
		List<KhachHangDTO> list = new ArrayList<>();
		List<KhachHang> khachHangs = khRepo.findAll();
		for (KhachHang khachHang : khachHangs) {
			list.add(conver.fromKhachHang(khachHang));
		}
		return list;
	}

	@Override
	public KhachHangDTO findOne(String makh) {
		Optional<KhachHang> kh = khRepo.findById(makh);
		return conver.fromKhachHang(kh.orElse(null));
	}

	@Override
	public void save(KhachHangDTO kh) {
		KhachHang khEn = conver.toKhachHang(kh);
		khRepo.save(khEn);
	}

	@Override
	public void delete(String serial) {
		khRepo.deleteById(serial);
	}

	@Override
	public Page<KhachMayDichVuDTO> getInfor(Pageable pageable, String value) {
		Page<KhachHang> khachHangs = null;
		if (value == null) {
			khachHangs = khRepo.findBySuDungDichVuIsNotNull(pageable);
		} else {
			khachHangs = khRepo.findByTenKHContainingAndSuDungDichVuIsNotNull(value, pageable);
		}
		List<KhachMayDichVuDTO> dtoList = new ArrayList<>();

		for (KhachHang khachHang : khachHangs) {
			KhachMayDichVuDTO dto = new KhachMayDichVuDTO();
			dto.setMaKH(khachHang.getMaKH());
			dto.setTenKH(khachHang.getTenKH());

			if (khachHang.getSuDungDichVu() != null) {
				for (SuDungDichVu suDungDichVu : khachHang.getSuDungDichVu()) {
					dto.setMaDV(suDungDichVu.getDichVu().getMaDV());
					dto.setNgaySuDungDV(suDungDichVu.getId().getNgaySuDung());
					dto.setSoLuong(suDungDichVu.getSoLuong());
					dto.setGioSuDungDV(suDungDichVu.getId().getGioSuDung());
					dto.setTongTien(suDungDichVu.getSoLuong() * suDungDichVu.getDichVu().getDonGia());
				}
			}

			if (khachHang.getSuDungMay() != null) {
				for (SuDungMay may : khachHang.getSuDungMay()) {
					dto.setThoiGianSuDungMay(may.getThoiGianSuDung());
					dto.setMaMay(may.getMay().getMaMay());
					dto.setViTri(may.getMay().getViTri());
					dto.setTrangThai(may.getMay().getTrangThai());
					dto.setGioBatDauSuDungMay(may.getId().getGioBatDau());
					dto.setNgayBatDauSuDungMay(may.getId().getNgayBatDauSuDung());
				}
			}

			dtoList.add(dto);
		}

		return new PageImpl<>(dtoList, pageable, khachHangs.getTotalElements());
	}

	@Override
	public List<KhachHang> listKhachHangSuDungDichVu() {
		return null;
	}

	@Override
	public Page<KhachHangDTO> findAll(Pageable pageable) {
		Page<KhachHang> khachHangs = khRepo.findAll(pageable);
		List<KhachHangDTO> khachHangDTOs = new ArrayList<>();
		for (KhachHang khachHang : khachHangs) {
			khachHangDTOs.add(conver.fromKhachHang(khachHang));
		}
		return new PageImpl<>(khachHangDTOs, pageable, khachHangs.getTotalElements());
	}

	@Override
	public Page<KhachHang> findByTenKHContaining(String keyword, Pageable pageable) {
		return khRepo.findByTenKHContaining(keyword, pageable);
	}

	@Override
	public long count() {
		return khRepo.count();
	}

	@Override
	public Page<KhachHangDTO> findByTen(String ten, Pageable pageable) {
		Page<KhachHang> kh = khRepo.findByTenKHContaining(ten, pageable);
		List<KhachHangDTO> khachHangDTOs = new ArrayList<>();
		for (KhachHang khachHangDTO : kh) {
			khachHangDTOs.add(conver.fromKhachHang(khachHangDTO));
		}
		return new PageImpl<KhachHangDTO>(khachHangDTOs, pageable, kh.getTotalElements());
	}

}
