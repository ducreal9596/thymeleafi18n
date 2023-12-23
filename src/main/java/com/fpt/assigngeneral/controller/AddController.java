package com.fpt.assigngeneral.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fpt.assigngeneral.convert.ConvertKhachHang;
import com.fpt.assigngeneral.dto.KhachHangDTO;
import com.fpt.assigngeneral.entities.DichVu;
import com.fpt.assigngeneral.entities.KhachHang;
import com.fpt.assigngeneral.entities.May;
import com.fpt.assigngeneral.entities.SuDungDichVu;
import com.fpt.assigngeneral.entities.SuDungDichVuID;
import com.fpt.assigngeneral.entities.SuDungMay;
import com.fpt.assigngeneral.entities.SuDungMayID;
import com.fpt.assigngeneral.service.DichVuService;
import com.fpt.assigngeneral.service.KhachHangService;
import com.fpt.assigngeneral.service.MayService;
import com.fpt.assigngeneral.service.SuDungDichVuService;
import com.fpt.assigngeneral.service.SuDungMayService;

import jakarta.transaction.Transactional;

@Controller
public class AddController {
	private int limit = 3;

	private KhachHangService khService;
	private DichVuService dvService;
	private MayService mService;
	private SuDungMayService sdService;
	private SuDungDichVuService sddvService;
	private ConvertKhachHang converKH;

	@Autowired
	public AddController(KhachHangService khService, DichVuService dvService, MayService mService,
			SuDungMayService sdService, SuDungDichVuService sddvService, ConvertKhachHang converKH) {
		this.khService = khService;
		this.dvService = dvService;
		this.mService = mService;
		this.sdService = sdService;
		this.sddvService = sddvService;
		this.converKH = converKH;
	}

	@GetMapping(value = "/add/{path}")
	public ModelAndView addKhachHang(@PathVariable String path, Model model) {
		Object obj = null;
		switch (path) {
		case "khachhang":
			obj = new KhachHang();
			break;
		case "may":
			obj = new May();
			break;
		case "dichvu":
			obj = new DichVu();
			break;
		case "sudungdichvu":
			obj = new SuDungDichVu();
			break;
		case "sudungmay":
			obj = new SuDungMay();
			break;
		default:
			break;
		}
		model.addAttribute("model", obj);
		ModelAndView mav = new ModelAndView("html/add/" + path);
		return mav;
	}

	@PostMapping(value = "/add/khachhang")
	public String addKhachHang(@ModelAttribute("model") @Validated KhachHangDTO obj, BindingResult result) {
		Long countPage = khService.count();
		int page = (int) Math.ceil(countPage / 3);
		KhachHangDTO kh = khService.findOne(obj.getMaKH());
		if (kh != null) {
			result.rejectValue("maKH", "maKH.exists", "Khách hàng dã tồn tại");
		}
		if (result.hasErrors()) {
			return "html/add/khachhang";
		}
		khService.save(obj);
		return "redirect:/list/khachhang?page=" + (page + 1) + "&limit=" + limit;
	}

	@PostMapping(value = "/add/dichvu")
	@Transactional
	public String addModel(@ModelAttribute("model") @Validated DichVu obj, BindingResult result) {
		DichVu dichVu = dvService.findOne(obj.getMaDV());
		long countPage = dvService.count();
		int page = (int) Math.ceil(countPage / 3);
		if (dichVu != null) {
			result.rejectValue("maDV", "maDV.exists", "Dịch vụ dã tồn tại");
		}
		if (result.hasErrors()) {
			return "html/add/dichvu";
		}
		dvService.save(obj);
		return "redirect:/list/dichvu?page=" + (page + 1) + "&limit=" + limit;
	}

	@PostMapping(value = "/add/may")
	@Transactional
	public String addMay(@ModelAttribute("model") @Validated May obj, BindingResult result) {
		Long countPage = mService.count();
		int page = (int) Math.ceil(countPage / 3);
		May may = mService.findOne(obj.getMaMay());
		if (may != null) {
			result.rejectValue("maMay", "maMay.exists", "Máy dã tồn tại");
		}
		if (result.hasErrors()) {
			return "html/add/may";
		}
		mService.save(obj);
		return "redirect:/list/may?page=" + (page + 1) + "&limit=" + limit;
	}

	@PostMapping(value = "/add/sudungmay")
	@Transactional
	public String addSuDungMay(@ModelAttribute("model") @Validated SuDungMay obj, BindingResult result) {
		KhachHangDTO kh = khService.findOne(obj.getId().getMa_khach_hang());
		May may = mService.findOne(obj.getId().getMa_may());
		if (kh == null) {
			result.rejectValue("id.ma_khach_hang", "id.ma_khach_hang.exists", "Khách hàng không tồn tại");
		}
		if (may == null) {
			result.rejectValue("id.ma_may", "id.ma_may.exists", "Máy không tồn tại");
		}
		if (result.hasErrors()) {
			return "html/add/sudungmay";
		}
		SuDungMayID id = new SuDungMayID(kh.getMaKH(), may.getMaMay(), obj.getId().getNgayBatDauSuDung(),
				obj.getId().getGioBatDau());
		obj.setId(id);
		obj.setKhachHang(converKH.toKhachHang(kh));
		obj.setMay(may);
		obj.setThoiGianSuDung(obj.getThoiGianSuDung());
		sdService.save(obj);
		return "redirect:/home";
	}

	@PostMapping(value = "/add/sudungdichvu")
	@Transactional
	public String addSuDungDichVu(@ModelAttribute("model") @Validated SuDungDichVu obj, BindingResult result) {
		KhachHangDTO kh = khService.findOne(obj.getId().getMa_khach_hang());
		DichVu dichVu = dvService.findOne(obj.getId().getMa_dich_vu());
		if (kh == null) {
			result.rejectValue("id.ma_khach_hang", "id.ma_khach_hang.exists", "Khách hàng không tồn tại");
		}
		if (dichVu == null) {
			result.rejectValue("id.ma_dich_vu", "ma_dich_vu.exists", "Dịch vụ không tồn tại");
		}
		if (result.hasErrors()) {
			return "html/add/sudungdichvu";
		} 
		SuDungDichVuID id = new SuDungDichVuID(kh.getMaKH(), dichVu.getMaDV(), obj.getId().getNgaySuDung(),
				obj.getId().getGioSuDung());
		obj.setId(id);
		obj.setKhachHang(converKH.toKhachHang(kh));
		obj.setDichVu(dichVu);
		obj.setSoLuong(obj.getSoLuong());
		sddvService.save(obj);
		return "redirect:/home";
	}
} 
