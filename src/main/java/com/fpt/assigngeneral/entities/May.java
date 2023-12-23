package com.fpt.assigngeneral.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MAY")
public class May {

	@Id
	@Column(name = "may", columnDefinition = "varchar(20)")
	@Pattern(regexp = "M\\d{3}", message = "Vui lòng nhập đúng định dạng. Mxxx")
	private String maMay;

	@NotEmpty(message = "Vui lòng nhập vị trí")
	@Column(name = "vi_tri", columnDefinition = "nvarchar(100)")
	private String viTri;

	@NotEmpty(message = "Vui lòng nhập trạng thái")
	@Column(name = "trang_thai", columnDefinition = "nvarchar(100)")
	private String trangThai;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "may")
	private Set<SuDungMay> suDungMay;
}
