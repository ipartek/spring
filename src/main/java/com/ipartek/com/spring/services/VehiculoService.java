package com.ipartek.com.spring.services;

import java.io.Serializable;
import java.util.List;

import com.ipartek.com.spring.domain.Vehiculo;

public interface VehiculoService extends Serializable {

	List<Vehiculo> getAll();

}
