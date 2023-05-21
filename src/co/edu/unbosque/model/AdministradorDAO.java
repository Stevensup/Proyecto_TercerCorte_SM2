package co.edu.unbosque.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import co.edu.unbosque.model.persistance.FileHandler;

public class AdministradorDAO implements OperacionesDAO {
	private ArrayList<AdministradorDTO> lista;

	public AdministradorDAO() {
		try {
			lista = loadFromFile();
		} catch (Exception e) {
			lista = new ArrayList<>();
		}
	}

	public ArrayList<AdministradorDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<AdministradorDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void add(Object o) {
		lista.add((AdministradorDTO) o);
	}

	@Override
	public boolean update(int index, Object o) {
		try {
			lista.set(index, (AdministradorDTO) o);
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

	public ArrayList<AdministradorDTO> loadFromFile() {
		ArrayList<AdministradorDTO> from_file = new ArrayList<>();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String contenido = FileHandler.abrirArchivoDeTexto("Admi.txt");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attrs = linea.split(";");
			String id = attrs[0];
			String name = attrs[1];
			String lastname = attrs[2];
			String gender = attrs[3];
			String user = attrs[4];
			String alternativemail = attrs[5];
			String password = attrs[7];
			from_file.add(new AdministradorDTO(id, name, lastname, gender, user, alternativemail, password));
		}
		return from_file;
	}
}
