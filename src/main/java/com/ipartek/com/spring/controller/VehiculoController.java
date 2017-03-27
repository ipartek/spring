package com.ipartek.com.spring.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ipartek.com.spring.domain.Vehiculo;
import com.ipartek.com.spring.services.VehiculoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class VehiculoController {

	private static final Logger LOG = LoggerFactory.getLogger(VehiculoController.class);

	@Autowired
	private VehiculoService vehiculoService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/vehiculo", method = RequestMethod.GET)
	public String listar(Locale locale, Model model) {

		List<Vehiculo> list = (List<Vehiculo>) vehiculoService.getAll();

		model.addAttribute("vehiculos", list);
		model.addAttribute("total", list.size());

		LOG.info("Listando Vehiculos " + list.size());

		return "vehiculo/index";
	}

	/**
	 * Ir al formulario de edicion<br>
	 * Escucha en la ruta: http://localhost:8080/vehiculo?edit
	 * 
	 */
	@RequestMapping(value = "/vehiculo", method = RequestMethod.GET, params = "edit")
	public String irFomulario(Locale locale, Model model) {

		LOG.info("Ir formulario edici�n");
		model.addAttribute("vehiculo", new Vehiculo());
		return "vehiculo/form";
	}

	@RequestMapping(value = "/vehiculo", method = RequestMethod.POST)
	public String edicion(@Valid Vehiculo vehiculo, BindingResult bindingResult) {
		LOG.info("editando vehiculo " + vehiculo.toString());
		if (bindingResult.hasErrors()) {
			LOG.warn("No pasa la validaci�n");
		} else {
			LOG.warn("validaci�n correcta");
		}
		return "vehiculo/form";
	}

}
