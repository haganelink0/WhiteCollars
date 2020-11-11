package com.itacademy.botigaCuadres.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.botigaCuadres.dto.ShopResponseDto;
import com.itacademy.botigaCuadres.repository.ShopRepository;
import com.itacademy.botigaCuadres.service.IShopService;

@Service
public class ShopServiceImpl implements IShopService {
	
	@Autowired
	ShopRepository repository;
	

	@Override
	public Optional<ShopResponseDto> getShop(int id) {
		return repository.findById(id);

	}

	@Override
	public Iterable<ShopResponseDto> getAll() {
		return repository.findAll();
	}

	@Override
	public void insertShop(ShopResponseDto shop) {
		repository.save(shop);
		
	}

	@Override
	public void deleteShop(ShopResponseDto shop) {
		repository.delete(shop);
		
	}

}
