package com.fpt.assigngeneral.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class KhachMayDichVuDTO {
	private String maKH;
	private String tenKH;
	private String maMay;
	private String viTri;
	private String trangThai;
	private Date ngayBatDauSuDungMay;
	private String gioBatDauSuDungMay;
	private String thoiGianSuDungMay;
	private String maDV;
	private Date ngaySuDungDV;
	private String gioSuDungDV;
	private int soLuong;
	private double tongTien;
}
