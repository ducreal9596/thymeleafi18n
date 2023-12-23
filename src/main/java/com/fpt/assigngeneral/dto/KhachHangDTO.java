package com.fpt.assigngeneral.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class KhachHangDTO {

	@Pattern(regexp = "KH\\d{3}", message = "Vui lòng nhập đúng định dạng. KHxxx")
	private String maKH;
	@NotBlank(message = "Vui lòng nhập tên khách hàng")
	private String tenKH;
	@NotBlank(message = "Vui lòng nhập địa chỉ")
	private String diaChi;
	@Pattern(regexp = "^(?:\\(\\+84\\))?(?:09\\d{8}|091\\d{7})$", message = "Vui lòng nhập số điện thoại hợp lệ")
	private String soDienThoai;
	@NotBlank(message = "Vui lòng nhập email")
	@Email(message = "Email không đúng định dạng")
	private String email;
	private String page;

}
