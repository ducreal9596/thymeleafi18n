package com.fpt.assigngeneral.entities;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "KHACH_HANG")
public class KhachHang {

	@Id
	@Column(name = "ma_khach_hang", columnDefinition = "varchar(20)")
	@Pattern(regexp = "KH\\d{3}", message = "Vui lòng nhập đúng định dạng. KHxxx")
	private String maKH;

	@NotBlank(message = "Vui lòng nhập tên khách hàng")
	@Column(name = "ten_khach_hang", columnDefinition = "nvarchar(255)")
	private String tenKH;

	@NotBlank(message = "Vui lòng nhập địa chỉ")
	@Column(name = "dia_chi", columnDefinition = "nvarchar(255)")
	private String diaChi;

	@Pattern(regexp = "^(?:\\(\\+84\\))?(?:09\\d{8}|091\\d{7})$", message = "Vui lòng nhập số điện thoại hợp lệ")
	@Column(name = "so_dien_thoai", columnDefinition = "varchar(20)")
	private String soDienThoai;

	@NotBlank(message = "Vui lòng nhập email")
	@Email(message = "Email không đúng định dạng")
	@Column(name = "email", columnDefinition = "varchar(255)")
	private String email;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "khachHang")
	private Set<SuDungDichVu> suDungDichVu;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "khachHang")
	private Set<SuDungMay> suDungMay;
}
