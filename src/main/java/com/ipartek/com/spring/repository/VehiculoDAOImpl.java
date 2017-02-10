package com.ipartek.com.spring.repository;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.com.spring.domain.Vehiculo;
import com.ipartek.com.spring.repository.mapper.VehiculoMapper;

@Repository("vehiculoDAO")
public class VehiculoDAOImpl implements VehiculoDAO {

	private static final long serialVersionUID = 1L;
	private final Log logger = LogFactory.getLog(getClass());

	private static final String SQL_GET_ALL = "SELECT `id`, `marca`, `precio`, `imagen` FROM `vehiculo` ORDER BY `id` DESC LIMIT 500;";
	private static String SQL_INSERT = "INSERT INTO `vehiculo` (`marca`, `precio`, `imagen`) VALUES ( ? , ? , ? );";

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbctemplate;
	private SimpleJdbcCall jdbcCall;

	@Autowired
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbctemplate = new JdbcTemplate(this.dataSource);
		this.jdbcCall = new SimpleJdbcCall(this.dataSource);
	}

	@Override
	public List<Vehiculo> getAll() {
		ArrayList<Vehiculo> lista = new ArrayList<Vehiculo>();

		try {
			lista = (ArrayList<Vehiculo>) this.jdbctemplate.query(SQL_GET_ALL, new VehiculoMapper());

		} catch (EmptyResultDataAccessException e) {
			this.logger.warn("No existen vehiculos todavia");
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}

		return lista;
	}

	@Override
	public boolean create(Vehiculo v) {
		boolean resul = false;

		return false;
	}

}
