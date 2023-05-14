package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Date;

import co.edu.unbosque.model.persistance.FileHandler;

public class AdministradorDAO implements OperacionesDAO {
	private ArrayList<AdministradorDTO> lista;

	public AdministradorDAO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<AdministradorDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AdministradorDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		lista.add((AdministradorDTO) o);
	}

	@Override
	public boolean update(int index, Object o) {
		try {
			lista.set(index, (AdministradorDTO) o);
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
		for (AdministradorDTO v : lista) {
			sb.append("Indice: " + index + sb.append(v.toString()));
		}
		return sb.toString();
	}

	public ArrayList<PersonaDTO> loadFromFile() {
		ArrayList<PersonaDTO> from_file = new ArrayList<>();
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
			String password = attrs[7];
			from_file.add(new AdministradorDTO(id, name, lastname, gender, user, alternativemail, birthdate, password));
		}
		return from_file;
	}

	public void writeOnFile() {
		StringBuilder sb = new StringBuilder("");
		int index = lista.size();
		for (AdministradorDTO v : lista) {
			sb.append(v.getId() + ";");
			sb.append(v.getName() + ";");
			sb.append(v.getLastname() + ";");
			sb.append(v.getGender() + ";");
			sb.append(v.getUser() + ";");
			sb.append(v.getAlternativemail() + ";");
			sb.append(v.getBirthdate() + ";");
			sb.append(v.getPassword() + ";");

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
