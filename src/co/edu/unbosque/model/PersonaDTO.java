package co.edu.unbosque.model;

import java.util.Date;

public class PersonaDTO {
	private String id;
	private String name;
	private String lastname;
	private String gender;
	private String user;
	private String alternativemail;
	private Date birthdate;

	public PersonaDTO() {
		// TODO Auto-generated constructor stub
	}

	public PersonaDTO(String id, String name, String lastname, String gender, String user, String alternativemail,
			Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.user = user;
		this.alternativemail = alternativemail;
		this.birthdate = birthdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAlternativemail() {
		return alternativemail;
	}

	public void setAlternativemail(String alternativemail) {
		this.alternativemail = alternativemail;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Documento: " + getId() + "\n");
		sb.append("Nombre: " + getName() + "\n");
		sb.append("Apellido:" + getId() + "\n");
		sb.append("Genero: " + getGender() + "\n");
		sb.append("Usuario: " + getUser() + "\n");
		sb.append("Correo alternativo: " + getAlternativemail() + "\n");
		sb.append("Fecha de nacimiento: " + getBirthdate() + "\n");
		return sb.toString();
	}
}
