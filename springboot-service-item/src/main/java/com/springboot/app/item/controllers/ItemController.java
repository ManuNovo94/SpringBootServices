package com.springboot.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.app.item.models.Item;
import com.springboot.app.item.models.Producto;
import com.springboot.app.item.models.service.ItemService;

@RestController
public class ItemController {

	@Autowired // inyectamos
	@Qualifier("ServiceFeign") // prioridad
	private ItemService itemService;

	@GetMapping("/listar")
	public List<Item> list() {

		return itemService.findAll();

	}

	@HystrixCommand(fallbackMethod = "metodoAlternativo") // añadiendo tolerancia a fallos , si ocurre fallo cogera la ruta alternativa 
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detail(@PathVariable Long id, @PathVariable Integer cantidad) // datos insertados desde navegador
	{

		return itemService.findById(id, cantidad);
	}

	public Item metodoAlternativo(Long id, Integer cantidad) { // en caso de error cogera este metodo
		Item item = new Item();
		Producto producto = new Producto();

		item.setCantidad(cantidad);
		producto.setId(id);
		producto.setNombre("prueba");
		producto.setPrecio(1.0);
		item.setProducto(producto);
		
	
		
		return item;

	}

}
