package co.edu.unbosque.model;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import co.edu.unbosque.model.persistance.FileHandler;

/**
 * 
 * @author Codernautas
 *
 */
public class AdministradorDAO implements OperacionesDAO {
	private ArrayList<AdministradorDTO> lista;

	public AdministradorDAO() {
		try {
			lista = loadFromFile();
		} catch (Exception e) {
			lista = new ArrayList<>();
		}
	}

	/**
	 * @return the lista
	 */
	public ArrayList<AdministradorDTO> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(ArrayList<AdministradorDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void add(Object o) {
		lista.add((AdministradorDTO) o);
		writeOnFile();
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
	public boolean delete(String doc) {
		try {
			for (int i = 0; i < lista.size(); i++) {
				if (lista.get(i).getId().equals(doc)) {
					lista.remove(i);
				} else {
				}
			}
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

	/**
	 * Este metodo se encargar de cargar en un array todas las caracteristicas
	 * guardadas en persistenacia
	 * 
	 * @return
	 */
	public ArrayList<AdministradorDTO> loadFromFile() {
		ArrayList<AdministradorDTO> from_file = new ArrayList<>();
		String contenido = FileHandler.abrirArchivoDeTexto("datosAdmi.txt");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attrs = linea.split(";");
			String id = attrs[0];
			String name = attrs[1];
			String lastname = attrs[2];
			String gender = attrs[3];
			String user = attrs[4];
			String alternativemail = attrs[5];
			String password = attrs[6];
			from_file.add(new AdministradorDTO(id, name, lastname, gender, user, alternativemail, password));
		}
		return from_file;
	}

	/**
	 * Este metodo se encarga de implmentar el FileHandler para escribir las
	 * caracteristicas y poder conservar asi la persistencia
	 */
	public void writeOnFile() {
		StringBuilder sb = new StringBuilder("");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		for (AdministradorDTO v : lista) {
			sb.append(v.getId() + ";");
			sb.append(v.getName() + ";");
			sb.append(v.getLastname() + ";");
			sb.append(v.getGender() + ";");
			sb.append(v.getUser() + ";");
			sb.append(v.getAlternativemail() + ";");
			sb.append(v.getPassword() + "\n");
		}
		FileHandler.escribirArchivoDeTexto("datosAdmi.txt", sb.toString());
	}
}
