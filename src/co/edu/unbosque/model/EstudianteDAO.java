package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.persistance.FileHandler;

public class EstudianteDAO implements OperacionesDAO {
	private ArrayList<EstudianteDTO> lista;

	public EstudianteDAO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<EstudianteDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<EstudianteDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		lista.add((EstudianteDTO) o);
	}

	@Override
	public boolean update(int index, Object o) {
		try {
			lista.set(index, (EstudianteDTO) o);
			writeOnFile();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean delete(int index) {
		try {
			lista.remove(index);
			writeOnFile();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String showAll() {
		StringBuilder sb = new StringBuilder();
		int index = 1;
		for (EstudianteDTO v : lista) {
			sb.append("Indice: " + index + sb.append(v.toString()));
		}
		return sb.toString();
	}

	public ArrayList<PersonaDTO> loadFromFile() {
		ArrayList<PersonaDTO> desde_archivo = new ArrayList<>();
		String contenido = FileHandler.openFileTxt("datosEst.csv");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attrs = linea.split(";");
			String id = attrs[0];
			String name = attrs[1];
			String lastname = attrs[2];
			String gender = attrs[3];
			String user = attrs[4];
			String alternativemail = attrs[5];
			Date birthdate = attrs[6];
			boolean status;
			if (attrs[7].equalsIgnoreCase("Activo")) {
				status = true;
			} else {
				status = false;
			}
			String career = attrs[8];
			String time = attrs[9];
			desde_archivo.add(new EstudianteDTO(id, name, lastname, gender, user, alternativemail, birthdate, status,
					career, time));
		}
		return desde_archivo;
	}

	public void writeOnFile() {
		StringBuilder sb = new StringBuilder("");
		int index = lista.size();
		for (EstudianteDTO v : lista) {
			sb.append(v.getId() + ";");
			sb.append(v.getName() + ";");
			sb.append(v.getLastname() + ";");
			sb.append(v.getGender() + ";");
			sb.append(v.getUser() + ";");
			sb.append(v.getAlternativemail() + ";");
			sb.append(v.getBirthdate() + ";");
			sb.append((v.isState() ? "Activo" : "Inactivo") + ";");
			sb.append(v.getCareer() + ";");
			sb.append(v.getTime() + ";");

			if (index == 1) {
				continue;
			} else {
				index--;
				sb.append("\n");
			}
		}
		FileHandler.writeFileTxt("datosEst.csv", sb.toString());
	}
}
