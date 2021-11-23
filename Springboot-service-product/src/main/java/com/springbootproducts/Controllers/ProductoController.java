package com.springbootproducts.Controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproducts.models.entity.Producto;
import com.springbootproducts.models.service.IProductoService;

@RestController // devuelve un JSON controlador del servicio 
public class ProductoController {

	@Autowired
	private Environment env;

	@Autowired // inyeccion
	private IProductoService productoService;

	@GetMapping("/listar")
	public List<Producto> list() {
		// return productoService.findAll(); los busca todos
		return productoService.findAll().stream().map(producto -> {
			producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return producto;
		}).collect(Collectors.toList());// Obtener los datos y el puerto
	}

	@GetMapping("/ver/{id}")
	public Producto detail(@PathVariable Long id) {
		Producto producto = productoService.findByiD(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port"))); //asigna el puerto donde es publicado
		/*
		 * boolean ok=false;//simular fallo
		 * 
		 * if (!ok) {
		 * 
		 * throw new RuntimeException("ERROR, NO SE CARGA PRODUCTO");
		 * 
		 * }
		 */
		/*
		 * try { //añadimos timeOut para comprobar que se realiza el camino alternativo
		 * y despues cambiamos la configuración Thread.sleep(2000L);//si supera los
		 * tiempos de configuración lanzará camino alternativo } catch
		 * (InterruptedException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		
		
		return producto;
	}
}
