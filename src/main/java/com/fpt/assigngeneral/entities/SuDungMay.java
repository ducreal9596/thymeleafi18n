package com.fpt.assigngeneral.entities;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SU_DUNG_MAY")
public class SuDungMay {

	@EmbeddedId
	private SuDungMayID id;

	@NotEmpty(message = "Chọn thời gian sử dụng")
	@Column(name = "thoi_gian_su_dung", columnDefinition = "DECIMAL")
	private String thoiGianSuDung;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@MapsId(value = "ma_khach_hang")
	private KhachHang khachHang;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@MapsId(value = "ma_may")
	private May may;

}
