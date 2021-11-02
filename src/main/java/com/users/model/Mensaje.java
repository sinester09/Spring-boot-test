package com.users.model;

public class Mensaje {

	private String mensaje;
	
	public Mensaje() {
		
	}
	
	public Mensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Mensaje [mensaje=" + mensaje + "]";
	}
}
