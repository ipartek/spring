package com.ipartek.com.spring.domain;

import javax.validation.constraints.Size;

public class Vehiculo {

	private long id;

	@Size(min = 2, max = 150, message = "Size.marca"
	// message = "marca '${validatedValue}' incorrecta, minimo {min} y maximo
	// {max}"
	)
	private String marca;

	private float precio;
	private String imagen;

	public Vehiculo() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", marca=" + marca + ", precio=" + precio + ", imagen=" + imagen + "]";
	}

}
