// package com.fpt.assigngeneral.api;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.fpt.assigngeneral.dto.KhachHangDTO;
// import com.fpt.assigngeneral.service.KhachHangService;

// @RestController
// @RequestMapping("/api/v1/khachhang")
// public class KhachHangAPI {

// 	@Autowired
// 	private KhachHangService khService;

// 	@GetMapping
// 	public ResponseEntity<Page<KhachHangDTO>> findAll(@RequestParam(defaultValue = "0") int page,
// 			@RequestParam(defaultValue = "10") int size,
// 			@RequestParam(defaultValue = "id", required = false) String sortField,
// 			@RequestParam(defaultValue = "asc") String sortOrder) {
// 		Sort sort = new Sort(Sort.Direction.fromString(sortOrder), sortField);
// 		Pageable pageable = new PageRequest(page, size, sort);
// 		Page<KhachHangDTO> khachHangDTOPage = khService.findAll(pageable);
// 		return ResponseEntity.ok(khachHangDTOPage);
// 	}

// 	@GetMapping("/{id}")
// 	public ResponseEntity<KhachHangDTO> findOne(@PathVariable String id) {
// 		KhachHangDTO khachHangDTO = khService.findOne(id);
// 		if (khachHangDTO != null) {
// 			return ResponseEntity.ok(khachHangDTO);
// 		} else {
// 			return ResponseEntity.notFound().build();
// 		}
// 	}

// 	@DeleteMapping("/{id}")
// 	public ResponseEntity<Void> deleteKhachHang(@PathVariable String id) {
// 		try {
// 			khService.delete(id);
// 			return ResponseEntity.noContent().build();
// 		} catch (Exception e) {
// 			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
// 		}
// 	}

// 	@GetMapping("/search")
// 	public ResponseEntity<Page<KhachHangDTO>> searchKhachHangByTen(@RequestParam String ten, @RequestParam int page,
// 			@RequestParam int size) {
// 		Pageable pageable = new PageRequest(page, size);
// 		Page<KhachHangDTO> khachHangDTOPage = khService.findByTen(ten, pageable);
// 		if (khachHangDTOPage.hasContent()) {
// 			return ResponseEntity.ok(khachHangDTOPage);
// 		} else {
// 			return ResponseEntity.notFound().build();
// 		}
// 	}

// }
