package com.springbootproducts.models.Dao;

import org.springframework.data.repository.CrudRepository;

import com.springbootproducts.models.entity.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

}
