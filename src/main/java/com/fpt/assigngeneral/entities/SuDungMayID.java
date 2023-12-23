package com.fpt.assigngeneral.entities;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SuDungMayID implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ma_khach_hang;

	private String ma_may;

	@NotBlank(message = "Vui lòng chọn ngày sử dụng")
	@NotNull
	@Column(name = "ngay_bat_dau_su_dung")
	private Date ngayBatDauSuDung;

	@NotBlank(message = "Chọn giờ bắt đầu sử dụng")
	@Column(name = "gio_bat_dau_su_dung")
	private String gioBatDau;
}