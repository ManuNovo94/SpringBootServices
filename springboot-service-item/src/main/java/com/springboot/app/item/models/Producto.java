package com.springboot.app.item.models;

import java.util.*;

public class Producto {

	private Long id;
	private String nombre;
	private double precio;
	private Date CreadoEn;
	
	private Integer port;

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getCreadoEn() {
		return CreadoEn;
	}

	public void setCreadoEn(Date creadoEn) {
		CreadoEn = creadoEn;
	}

}
