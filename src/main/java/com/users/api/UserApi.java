package com.users.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.users.model.Mensaje;
import com.users.model.User;
import com.users.model.UserRequest;
import com.users.service.UserService;

@RestController
public class UserApi {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public Object registerUser(@RequestBody UserRequest userRequest) {

		try {
			// Validacion de Entrada
			// Valida email
			if (!userService.isEmailValid(userRequest.getEmail())) {
				return new Mensaje("Formato incorrecto de email, debe ser de la forma aaaaaaa@dominio.cl​");
			}
			// Valida que no exista email
			if (userService.alreadyExistEmail(userRequest.getEmail())) {
				return new Mensaje("Este email ya existe en la base de datos​");
			}
			// Valida password
			if (!userService.isPasswordValid(userRequest.getPassword())) {
				return new Mensaje(
						"Formato incorrecto de la contraseña, debe tener una mayúscula, letras minúsculas, y dos números.​");
			}

			// Creacion de usuario
			User user = userService.getUserFromRequest(userRequest);
			userService.saveUser(user);
			user = userService.getUserById(user.getId());

			// Retorno de usuario creado
			return user;
		} catch (Exception ex) {
			return new Mensaje("Error interno: " + ex.getMessage());
		}
	}

}
