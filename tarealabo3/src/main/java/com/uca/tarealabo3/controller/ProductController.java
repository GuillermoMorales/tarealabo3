package com.uca.tarealabo3.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.tarealabo3.domain.Product;

@Controller
public class ProductController {
private List<Product> lista = new ArrayList<Product>();
	
	@GetMapping("/comprarProducto")
	public ModelAndView comprarProduct()
	{
		ModelAndView mav = new ModelAndView();
		
		lista.add(new Product(0,"GTA5",60));
		lista.add(new Product(1,"MINECRAFT",20));
		lista.add(new Product(2,"WOW",10));
		lista.add(new Product(3,"COD",8));
		lista.add(new Product(4,"ANIMAL CROSSING",60));
		lista.add(new Product(5,"GOW",44));
		lista.add(new Product(6,"LINK BETWEEN WORLDS",50));
		
		mav.setViewName("select");
		mav.addObject("product", new Product());/*Añadimos un nuevo producto vacio*/
		mav.addObject("producto", lista);/*Enviamos la lista de productos*/
		return mav;
	}
	
	@PostMapping("/validar")
	public ModelAndView validar(Product producto, @RequestParam String cantidad)/*Recibo un producto*/
	{
		
		int cant = Integer.parseInt(cantidad);
		int stock = lista.get(producto.getId()).getCantidad();/*EN la lista obtengo el Id, y luego acceder a la cantidad*/
		ModelAndView mav = new ModelAndView();
		String si = "Sí se puede comprar la cantidad de este producto";
		String no = "No se puede comprar la cantidad de este producto, sobrepasa el stock actual";
		
		if(stock > cant )
		{
			mav.addObject("resultado", si);
			mav.setViewName("resultado");
			return mav;
		}
		else
		{
			mav.addObject("resultado",no);
			mav.setViewName("resultado");
			return mav;
			/*return lista.get(producto.getId()).getNombre() + "\n" +lista.get(producto.getId()).getCantidad();	*/
		}
				
	}
}
