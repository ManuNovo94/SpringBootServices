package com.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.item.models.Item;
import com.springboot.app.item.models.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	@Qualifier("ServiceFeign")
	private ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item>list(){
		
		return itemService.findAll();
		
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detail(@PathVariable Long id, @PathVariable Integer cantidad) 
	{
		
		return itemService.findById(id, cantidad);
	}
	
}
