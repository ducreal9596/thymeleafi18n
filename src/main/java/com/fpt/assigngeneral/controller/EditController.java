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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fpt.assigngeneral.dto.KhachHangDTO;
import com.fpt.assigngeneral.entities.DichVu;
import com.fpt.assigngeneral.entities.May;
import com.fpt.assigngeneral.service.DichVuService;
import com.fpt.assigngeneral.service.KhachHangService;
import com.fpt.assigngeneral.service.MayService;



@Controller
public class EditController {

	@Autowired
	private KhachHangService khService;

	@Autowired
	private MayService mService;

	@Autowired
	private DichVuService dvService;

	@GetMapping(value = "/edit/{path}/{id}")
	private ModelAndView editPage(@PathVariable String path, @PathVariable String id, Model model,
			@RequestParam(required = false) int page) {
		Object obj = null;
		switch (path) {
		case "khachhang":
			obj = khService.findOne(id);
			break;
		case "may":
			obj = mService.findOne(id);
			break;
		case "dichvu":
			obj = dvService.findOne(id);
			break;
		default:
			break;
		}
		model.addAttribute("model", obj);
		String urlpattern = "/edit/" + path + "/" + id;
		model.addAttribute("urlpattern", urlpattern);
		model.addAttribute("page", page);
		ModelAndView mav = new ModelAndView("html/add/" + path);
		return mav;
	}

	@PostMapping(value = "/edit/khachhang/{id}")
	private String editKhachHang(@PathVariable String id, @ModelAttribute("model") @Validated KhachHangDTO kh,
			BindingResult result, @RequestParam(required = false) int page) {
		if (result.hasErrors()) {
			return "redirect:/edit/khachhang/" + id + "?page=" + page;
		}
		kh.setMaKH(id);
		khService.save(kh);
		return "redirect:/list/khachhang?page=" + page + "&limit=3";
	}

	@PostMapping(value = "/edit/may/{id}")
	private String editMay(@PathVariable String id, @ModelAttribute("model") @Validated May may, BindingResult result,
			@RequestParam(required = false) int page) {
		may.setMaMay(id);
		if (result.hasErrors()) {
			return "redirect:/edit/may/" + id + "?page=" + page;
		}
		mService.save(may);
		return "redirect:/list/may?page=" + page + "&limit=3";
	}

	@PostMapping(value = "/edit/dichvu/{id}")
	private String editDichVu(@PathVariable String id, @ModelAttribute("model") @Validated DichVu dichVu,
			BindingResult result, @RequestParam int page) {
		dichVu.setMaDV(id);
		if (result.hasErrors()) {
			return "redirect:/edit/dichvu/" + id + "?page=" + page;
		}
		dvService.save(dichVu);
		return "redirect:/list/dichvu?page=" + page + "&limit=3";
	}
}
