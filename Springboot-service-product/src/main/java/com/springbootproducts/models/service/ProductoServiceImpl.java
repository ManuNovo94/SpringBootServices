package com.springbootproducts.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootproducts.models.Dao.ProductoDao;
import com.springbootproducts.models.entity.Producto;


@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired  //Importante inyecta el dao
	private ProductoDao productoDao;
	@Override
	@Transactional(readOnly = true)
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoDao.findAll(); //devuelve todos los datos
	}

	@Override
	public Producto findByiD(Long id) {
		// TODO Auto-generated method stub
		return productoDao.findById(id).orElse(null); // si no lo encuentra devuelve null
	}

}
