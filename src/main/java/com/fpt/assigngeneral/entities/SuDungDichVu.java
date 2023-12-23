package com.fpt.assigngeneral.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SU_DUNG_DICH_VU")
public class SuDungDichVu {

	@EmbeddedId
	private SuDungDichVuID id;

	@Column(name = "so_luong", columnDefinition = "INT")
	private int soLuong;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@MapsId(value = "ma_khach_hang")
	private KhachHang khachHang;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@MapsId(value = "ma_dich_vu")
	private DichVu dichVu;

}
