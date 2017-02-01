package com.ipartek.com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.com.spring.domain.Vehiculo;
import com.ipartek.com.spring.repository.VehiculoDAO;

@Service("vehiculoService")
public class VehiculoServiceImpl implements VehiculoService {

	private static final long serialVersionUID = 1L;

	private List<Vehiculo> vehiculos;

	@Autowired
	private VehiculoDAO VehiculoDAOImpl;

	@Override
	public List<Vehiculo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
