package co.edu.unbosque.model;

import java.util.Date;

public class EstudianteDTO extends PersonaDTO {
	private boolean state;
	private String career;
	private String time;

	public EstudianteDTO() {
		// TODO Auto-generated constructor stub
	}

	public EstudianteDTO(boolean state, String career, String time) {
		super();
		this.state = state;
		this.career = career;
		this.time = time;
	}

	public EstudianteDTO(String id, String name, String lastname, String gender, String user, String alternativemail,
			Date birthdate) {
		super(id, name, lastname, gender, user, alternativemail, birthdate);
		// TODO Auto-generated constructor stub
	}

	public EstudianteDTO(String id, String name, String lastname, String gender, String user, String alternativemail,
			Date birthdate, boolean state, String career, String time) {
		super(id, name, lastname, gender, user, alternativemail, birthdate);
		this.state = state;
		this.career = career;
		this.time = time;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("Tiene pelaje: " + (isState() ? "Activo" : "Inactivo") + "\n");
		sb.append("Programa academico: " + getCareer() + "\n");
		sb.append("Jornada: " + getTime() + "\n");
		return sb.toString();
	}
}
