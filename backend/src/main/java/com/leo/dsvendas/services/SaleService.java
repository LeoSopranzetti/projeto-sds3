package com.leo.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.leo.dsvendas.dto.SaleDTO;
import com.leo.dsvendas.dto.SaleSuccessDTO;
import com.leo.dsvendas.dto.SaleSumDTO;
import com.leo.dsvendas.entities.Sale;
import com.leo.dsvendas.repossitories.SaleRepository;
import com.leo.dsvendas.repossitories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO>findall(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedSeler(){
		return repository.amount();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> success(){
		return repository.success();
	}
}
