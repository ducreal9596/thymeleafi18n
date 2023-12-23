package com.fpt.assigngeneral.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class DichVuDTO {
	private String maDV;
	private String tenDV;
	private String donViTinh;
	private Double donGia;
	private String page;

	
}
