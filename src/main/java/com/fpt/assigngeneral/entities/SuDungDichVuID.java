package com.fpt.assigngeneral.entities;


import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
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
public class SuDungDichVuID implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ma_khach_hang;
	private String ma_dich_vu;
	@Column(name = "ngay_su_dung")
	@NotNull(message = "vui long nhap")
	private Date ngaySuDung;
	@Column(name = "gio_su_dung")
	private String gioSuDung;
}
