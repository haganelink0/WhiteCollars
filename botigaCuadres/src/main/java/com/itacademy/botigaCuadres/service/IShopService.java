package com.itacademy.botigaCuadres.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.itacademy.botigaCuadres.dto.ShopResponseDto;

@Service
public interface IShopService {
	
	Optional<ShopResponseDto> getShop(int id);
	
	Iterable<ShopResponseDto> getAll();
	
	void insertShop(ShopResponseDto shop);
	
	void deleteShop(ShopResponseDto shop);
	
	

}
