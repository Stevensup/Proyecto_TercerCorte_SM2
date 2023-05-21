package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Date;

public class UsuarioDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6198343242643655486L;
	private String id;
	private String name;
	private String lastname;
	private String gender;
	private String user;
	private String alternativemail;
	protected Date birthdate;
	protected boolean state;
	protected String career;
	protected String time;
	protected String origin;
	protected Date registrationdate;

	
	public UsuarioDTO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param id
	 * @param name
	 * @param lastname
	 * @param gender
	 * @param user
	 * @param alternativemail
	 */
	public UsuarioDTO(String id, String name, String lastname, String gender, String user, String alternativemail) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.user = user;
		this.alternativemail = alternativemail;
	}




	/**
	 * @param id
	 * @param name
	 * @param lastname
	 * @param gender
	 * @param user
	 * @param alternativemail
	 * @param birthdate
	 * @param state
	 * @param career
	 * @param time
	 * @param origin
	 * @param registrationdate
	 */
	public UsuarioDTO(String id, String name, String lastname, String gender, String user, String alternativemail,
			Date birthdate, boolean state, String career, String time, String origin, Date registrationdate) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.user = user;
		this.alternativemail = alternativemail;
		this.birthdate = birthdate;
		this.state = state;
		this.career = career;
		this.time = time;
		this.origin = origin;
		this.registrationdate = registrationdate;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * @return the alternativemail
	 */
	public String getAlternativemail() {
		return alternativemail;
	}

	/**
	 * @param alternativemail the alternativemail to set
	 */
	public void setAlternativemail(String alternativemail) {
		this.alternativemail = alternativemail;
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
	}

	/**
	 * @return the career
	 */
	public String getCareer() {
		return career;
	}

	/**
	 * @param career the career to set
	 */
	public void setCareer(String career) {
		this.career = career;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * @return the registrationdate
	 */
	public Date getRegistrationdate() {
		return registrationdate;
	}

	/**
	 * @param registrationdate the registrationdate to set
	 */
	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Documento: " + getId() + "\n");
		sb.append("Nombre: " + getName() + "\n");
		sb.append("Apellido:" + getLastname() + "\n");
		sb.append("Genero: " + getGender() + "\n");
		sb.append("Usuario: " + getUser() + "\n");
		sb.append("Correo alternativo: " + getAlternativemail() + "\n");
		sb.append("Fecha de nacimiento: " + getBirthdate() + "\n");
		sb.append("Estado: " + (isState() ? "Activo" : "Inactivo") + "\n");
		sb.append("Programa academico: " + getCareer() + "\n");
		sb.append("Jornada: " + getTime() + "\n");
		sb.append("Lugar de origen: " + getOrigin() + "\n");
		sb.append("Fecha de registro: " + getRegistrationdate() + "\n");

		return sb.toString();
	}

}
