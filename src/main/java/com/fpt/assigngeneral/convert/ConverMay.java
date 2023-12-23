package com.fpt.assigngeneral.convert;


import com.fpt.assigngeneral.dto.MayDTO;
import com.fpt.assigngeneral.entities.May;

public class ConverMay {
	public MayDTO fromMay(May may) {
		MayDTO mayDTO = new MayDTO();
		mayDTO.setMaMay(may.getMaMay());
		mayDTO.setViTri(may.getViTri());
		mayDTO.setTrangThai(may.getTrangThai());

		return mayDTO;
	}

	public May toMay(MayDTO mDTO) {
		May may = new May();
		may.setMaMay(mDTO.getMaMay());
		may.setViTri(mDTO.getViTri());
		may.setTrangThai(mDTO.getTrangThai());
		return may;
	}
}
