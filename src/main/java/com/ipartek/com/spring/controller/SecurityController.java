package com.ipartek.com.spring.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

	/**
	 * Accion principal al ejecutar la App.
	 * 
	 * Model:
	 * <ol>
	 * 		<li>title: titulo de la JSP</li>
	 *      <li>message: Mensaje par el usuario</li>
	 *      <li>path: ruta de la jsp que se ejecuta</li>
	 * </ol>
	 * <br>
	 * View:
	 * 	 	pagina principal index.jsp	
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Ongi Etorri");
		model.addObject("message", "Estamos en la pagina principal!");
		model.addObject("path", "\\src\\main\\webapp\\WEB-INF\\views\\index.jsp");
		model.setViewName("index");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Backoffice");
		model.addObject("message", "Solo accesible para ROLE_ADMIN !");
		model.setViewName("admin");
		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
				@RequestParam(value = "error", required = false) String error,
				@RequestParam(value = "logout", required = false) String logout
			) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Credenciales incorrectas!");
		}

		if (logout != null) {
			model.addObject("msg", "Logout Correcto, no dejes de visitarnos ;-P");
		}
		model.setViewName("login");

		return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);		
			model.addObject("username", userDetail.getUsername());			
		}
		
		model.setViewName("403");
		return model;

	}

}