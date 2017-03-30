package com.ipartek.com.spring.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ipartek.com.spring.domain.Vehiculo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class VehiculoDAOImplTest {

    @Autowired
    VehiculoDAO vehiculoDAO;

	
	@Test
	public void test() {
        assertEquals("class com.ipartek.com.spring.repository.VehiculoDAOImpl", this.vehiculoDAO.getClass().toString());
        
        
        ArrayList<Vehiculo> lista = (ArrayList<Vehiculo>) this.vehiculoDAO.getAll();
        assertNotNull("No deberia retornar null",lista);
        assertTrue ( lista.size() >= 0);
        
        
	}

}
