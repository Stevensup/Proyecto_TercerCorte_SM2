package co.edu.unbosque.model;

import java.util.Date;
/**
 * 
 * @author Codernautas
 *
 */

public class AdministradorDTO extends UsuarioDTO {
	private String password;

	public AdministradorDTO() {
		// TODO Auto-generated constructor stub
	}

	public AdministradorDTO(String id, String name, String lastname, String gender, String user, String alternativemail,
			String password) {
		super(id, name, lastname, gender, user, alternativemail);
		this.password = password;
	}

	public AdministradorDTO(String password) {
		this.password = password;
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
	 * @param password
	 */
	public AdministradorDTO(String id, String name, String lastname, String gender, String user, String alternativemail,
			Date birthdate, boolean state, String career, String time, String origin, Date registrationdate,
			String password) {
		super(id, name, lastname, gender, user, alternativemail, birthdate, state, career, time, origin,
				registrationdate);
		this.password = password;
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
	public AdministradorDTO(String id, String name, String lastname, String gender, String user, String alternativemail,
			Date birthdate, boolean state, String career, String time, String origin, Date registrationdate) {
		super(id, name, lastname, gender, user, alternativemail, birthdate, state, career, time, origin,
				registrationdate);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("ContraseNa: " + getPassword() + "\n");
		return sb.toString();
	}
}
