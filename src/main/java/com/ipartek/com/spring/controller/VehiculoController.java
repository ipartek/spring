package com.ipartek.com.spring.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.com.spring.domain.Vehiculo;
import com.ipartek.com.spring.services.VehiculoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class VehiculoController {

	private static final Logger logger = LoggerFactory.getLogger(VehiculoController.class);

	@Autowired
	private VehiculoService vehiculoService;

	public void setVehiculoService(VehiculoService vehiculoService) {
		this.vehiculoService = vehiculoService;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/vehiculo", method = RequestMethod.GET)
	public String listar(Locale locale, Model model) {

		List<Vehiculo> list = (List<Vehiculo>) vehiculoService.getAll();

		model.addAttribute("vehiculos", list);

		logger.info("Listando Vehiculos " + list.size());

		return "vehiculo/index";
	}

}
