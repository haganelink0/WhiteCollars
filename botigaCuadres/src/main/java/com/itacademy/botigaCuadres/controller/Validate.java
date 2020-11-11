package com.itacademy.botigaCuadres.controller;

import com.itacademy.botigaCuadres.dto.PaintingResponseDto;
import com.itacademy.botigaCuadres.dto.ShopResponseDto;

public class Validate {
	

		
		public static Boolean isShopValid (ShopResponseDto shop) {
			Boolean response = true;
			
			if(shop.getName() == null || shop.getShopId() == null || shop.getPaints() == null) {
				response = false;
			}
			
			return response;
		}
		
		public static Boolean isPaintValid (PaintingResponseDto paint) {
			Boolean response = true;
			
			if(paint.getTitle() == null ||paint.getAuthor() == null || paint.getPrice() == null || paint.getShop() == null) {
				response = false;
			}
			
			return response;
		}


}
