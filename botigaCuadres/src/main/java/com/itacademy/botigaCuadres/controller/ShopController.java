package com.itacademy.botigaCuadres.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.botigaCuadres.controller.exceptions.InvalidJson;
import com.itacademy.botigaCuadres.controller.exceptions.ResourceNotFound;
import com.itacademy.botigaCuadres.controller.exceptions.ShopIsFull;
import com.itacademy.botigaCuadres.dto.PaintingResponseDto;
import com.itacademy.botigaCuadres.dto.ShopResponseDto;
import com.itacademy.botigaCuadres.service.impl.PaintingServiceImpl;
import com.itacademy.botigaCuadres.service.impl.ShopServiceImpl;

@RestController
@RequestMapping("/apishop/")
@CrossOrigin(origins = "http://localhost:8080", 
			 methods= {RequestMethod.GET, RequestMethod.POST})
public class ShopController {
	
	@Autowired
	private ShopServiceImpl shopService;
	
	@Autowired
	private PaintingServiceImpl paintingService;

	
	@GetMapping("/shops/")
	public ResponseEntity<Iterable<ShopResponseDto>> viewAllShops() {
		return new ResponseEntity<>(shopService.getAll(), HttpStatus.OK);
		
	}
	
	@PostMapping(path="/shops/", consumes="application/json")
	public ResponseEntity<ShopResponseDto> insertShop(@RequestBody ShopResponseDto shop) throws InvalidJson {
		if (Validate.isShopValid(shop).equals(false)) {
			throw new InvalidJson();
		}
		
		shopService.insertShop(shop);
		return new ResponseEntity<>(shop,HttpStatus.OK);
	}
	
	@DeleteMapping("/shops/{id}")
	public void deleteShop(@PathVariable int id) throws ResourceNotFound {
		Optional<ShopResponseDto> tempShop = shopService.getShop(id);
		if (tempShop.isEmpty()) {
			throw new ResourceNotFound(id);
		}
		shopService.deleteShop(tempShop.get());
		paintingService.deleteAllPaintings(tempShop.get());
	}
	
	@PostMapping(path="/shops/{id}/painting", consumes="application/json")
	public ResponseEntity<PaintingResponseDto> addPainting(@PathVariable int id,@RequestBody PaintingResponseDto painting) throws 
																						ShopIsFull, ResourceNotFound, InvalidJson {
		Optional<ShopResponseDto> tempShop = shopService.getShop(id);
		if(tempShop.isEmpty()) {
			throw new ResourceNotFound(id);
		}
		if (Validate.isPaintValid(painting).equals(false)) {
			throw new InvalidJson();
		}
		if (tempShop.get().hasSpace()) {
			painting.setShop(tempShop.get());
			paintingService.savePainting(painting);
			return new ResponseEntity<>(painting, HttpStatus.OK);
		} else {
			throw new ShopIsFull("Shop is full");
		}
		
	}
	
	@GetMapping("/shops/{id}/painting")
	public ResponseEntity<Iterable<PaintingResponseDto>> viewPaintings(@PathVariable int id) throws ResourceNotFound {
		Optional<ShopResponseDto> tempShop = shopService.getShop(id);
		if (tempShop.isEmpty()) {
			throw new ResourceNotFound(id);
		}

		return new ResponseEntity<>(paintingService.getPaintingByShop(tempShop.get()), HttpStatus.OK);
	}
	

}
