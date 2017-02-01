package com.ipartek.com.spring.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.com.spring.domain.Vehiculo;

public class VehiculoMapper implements RowMapper<Vehiculo> {

	@Override
	public Vehiculo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vehiculo v = new Vehiculo();
		v.setId(rs.getLong("id"));
		v.setMarca(rs.getString("marca"));
		// TODO mapear resto de campos
		return v;
	}

}
