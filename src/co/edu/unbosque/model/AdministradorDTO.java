package co.edu.unbosque.model;

import java.util.Date;

public class AdministradorDTO extends PersonaDTO {
	private String password;

	public AdministradorDTO() {
		// TODO Auto-generated constructor stub
	}

	public AdministradorDTO(String password) {
		this.password = password;
	}

	public AdministradorDTO(String id, String name, String lastname, String gender, String user, String alternativemail,
			Date birthdate) {
		super(id, name, lastname, gender, user, alternativemail, birthdate);
		// TODO Auto-generated constructor stub
	}

	public AdministradorDTO(String id, String name, String lastname, String gender, String user, String alternativemail,
			Date birthdate, String password) {
		super(id, name, lastname, gender, user, alternativemail, birthdate);
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("Contraseña: " + getPassword() + "\n");
		return sb.toString();
	}
}
