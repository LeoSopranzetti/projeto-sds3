package com.leo.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.dsvendas.dto.SaleDTO;
import com.leo.dsvendas.dto.SaleSuccessDTO;
import com.leo.dsvendas.dto.SaleSumDTO;
import com.leo.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findall(Pageable pageable){
		Page<SaleDTO> list = service.findall(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/sum-by-seller")
	public ResponseEntity<List<SaleSumDTO>> group( ){
		List<SaleSumDTO> list = service.amountGroupedSeler();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> success( ){
		List<SaleSuccessDTO> list = service.success();
		return ResponseEntity.ok(list);
	}
}
