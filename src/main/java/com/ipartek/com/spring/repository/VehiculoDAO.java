package com.ipartek.com.spring.repository;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import com.ipartek.com.spring.domain.Vehiculo;

public interface VehiculoDAO extends Serializable {

	void setDataSource(DataSource dataSource);

	List<Vehiculo> getAll();

	boolean create(Vehiculo v);

}
