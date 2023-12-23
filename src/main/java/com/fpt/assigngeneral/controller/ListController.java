package com.fpt.assigngeneral.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fpt.assigngeneral.service.DichVuService;
import com.fpt.assigngeneral.service.KhachHangService;
import com.fpt.assigngeneral.service.MayService;
import com.fpt.assigngeneral.service.SuDungDichVuService;
import com.fpt.assigngeneral.service.SuDungMayService;


@Controller
public class ListController {

	@Autowired
	private KhachHangService khService;

	@Autowired
	private DichVuService dvService;

	@Autowired
	private MayService mService;

	@Autowired
	private SuDungMayService sdmService;

	@Autowired
	private SuDungDichVuService sddvService;

	@GetMapping(value = "/list/{path}")
	public ModelAndView getList(@PathVariable String path, @RequestParam("page") int pageParam,
			@RequestParam("limit") int limit, @RequestParam(name = "search", required = false) String search,
			Model model) {
		Pageable pageable = PageRequest.of(pageParam - 1, limit);
		Page<?> pageData = null;

		if ("khachhang".equals(path)) {
			if (search != null && !search.isEmpty()) {
				pageData = khService.findByTenKHContaining(search, pageable);
			} else {
				pageData = khService.findAll(pageable);
			}
		} else if ("dichvu".equals(path)) {
			if (search != null && !search.isEmpty()) {
				pageData = dvService.findByTenDVContaining(search, pageable);
			} else {
				pageData = dvService.findAll(pageable);
			}
		} else if ("may".equals(path)) {
			if (search != null && !search.isEmpty()) {
				pageData = mService.findByMaMayContaining(search, pageable);
			} else {
				pageData = mService.findAll(pageable);
			}
		} else if ("thongtinkhachhang".equals(path)) {
			if (search != null && !search.isEmpty()) {
				pageData = khService.getInfor(pageable, search);
			} else {
				pageData = khService.getInfor(pageable, null);
			}
		} else {
			return new ModelAndView("error/404");
		}

		ModelAndView mav = new ModelAndView("html/list/" + path);
		mav.addObject("modules", pageData.getContent());
		mav.addObject("currentPage", pageParam);
		mav.addObject("search", search);
		mav.addObject("totalPages", pageData.getTotalPages());
		mav.addObject("totalItems", pageData.getTotalElements());
		mav.addObject("pageSize", limit);
		return mav;
	}

	@GetMapping("/delete/{path}/{id}")
	public String delete(@PathVariable String path, @PathVariable String id) {
		if ("khachhang".equals(path)) {
			khService.delete(id);
		} else if ("dichvu".equals(path)) {
			dvService.delete(id);
		} else if ("may".equals(path)) {
			mService.delete(id);
		} else if ("sudungdichvu".equals(path)) {
			sddvService.delete(id);
		} else if ("sudungmay".equals(path)) {
			sdmService.delete(id);
		}
		return "redirect:/list/" + path + "?page=1&limit=3";
	}
} 