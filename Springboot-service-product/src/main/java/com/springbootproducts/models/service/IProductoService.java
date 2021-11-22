package com.springbootproducts.models.service;

import java.util.List;

import com.springbootproducts.models.entity.Producto;

public interface IProductoService {

	
	public List <Producto> findAll();
	public Producto findByiD(Long id);
	
}
