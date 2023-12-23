package com.fpt.assigngeneral.entities;


import java.util.Set;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "DICH_VU")
public class DichVu { 

	@Id
	@Column(name = "ma_dich_vu", columnDefinition = "varchar(20)")
	@Pattern(regexp = "DV\\d{3}", message = "Vui lòng nhập đúng định dạng. DVxxx")
	private String maDV;

	@NotEmpty(message = "Vui lòng tên mã dịch vụ")
	@Column(name = "Ten_dich_vu", columnDefinition = "nvarchar(255)")
	private String tenDV;

	@NotEmpty(message = "Vui lòng nhập đơn vị tính")
	@Column(name = "don_vi_tinh", columnDefinition = "nvarchar(100)")
	private String donViTinh;

	@NotNull(message = "Vui lòng nhập đơn giá")
	@NumberFormat(style = Style.NUMBER)
	@Column(name = "don_gia", columnDefinition = "MONEY")
	private Double donGia;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "dichVu")
	private Set<SuDungDichVu> suDungDichVu;

}
