/**
 * 
 */
package co.edu.unbosque.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import co.edu.unbosque.model.persistance.FileHandler;

/**
 * @author annie
 *
 */
public class UsuarioDAO implements OperacionesDAO {

	private ArrayList<UsuarioDTO> lista;

	public UsuarioDAO() {
		// try {
		// lista = cargarEstudiante();
//		} catch (Exception e) {
		lista = (ArrayList<UsuarioDTO>) FileHandler.leerSerializado("datosEst.dat");
		// }
	}

	/**
	 * @return the lista
	 */
	public ArrayList<UsuarioDTO> getLista() {
		return lista;
	}

	/**
	 * @param lista the lista to set
	 */
	public void setLista(ArrayList<UsuarioDTO> lista) {
		this.lista = lista;
	}

	@Override
	public void add(Object o) {
		lista.add((UsuarioDTO) o);
		writeOnFile();
	}

	@Override
	public boolean update(int index, Object o) {
		try {
			lista.set(index, (UsuarioDTO) o);
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
		for (UsuarioDTO v : lista) {
			sb.append("Indice: " + index + sb.append(v.toString()));
		}
		return sb.toString();
	}

	private ArrayList<UsuarioDTO> cargarEstudiante() {
		ArrayList<UsuarioDTO> from_file = new ArrayList<>();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String contenido = FileHandler.abrirArchivoDeTexto("datosEst.csv");
		String[] lineas = contenido.split("\n");
		for (String linea : lineas) {
			String[] attrs = linea.split(";");
			String id = attrs[0];
			String name = attrs[1];
			String lastname = attrs[2];
			String gender = attrs[3];
			String user = attrs[4];
			String alternativemail = attrs[5];
			boolean state = (attrs[7].equals("ACTIVO")) ? true : false;
			String career = attrs[8];
			String time = attrs[9];
			String origin = attrs[10];
			Date birthdate = null;
			Date registrationdate = null;
			try {
				birthdate = formato.parse(attrs[6]);
				registrationdate = formato.parse(attrs[11]);
			} catch (ParseException e) {

			}
			from_file.add(new UsuarioDTO(id, name, lastname, gender, user, alternativemail, birthdate, state, career,
					time, origin, registrationdate));
		}
		return from_file;
	}

	public void writeOnFile() {
		StringBuilder sb = new StringBuilder("");
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		for (UsuarioDTO v : lista) {
			sb.append(v.getId() + ";");
			sb.append(v.getName() + ";");
			sb.append(v.getLastname() + ";");
			sb.append(v.getGender() + ";");
			sb.append(v.getUser() + ";");
			sb.append(v.getAlternativemail() + ";");
			sb.append(formato.format(v.getBirthdate()) + ";");
			sb.append((v.isState() ? "ACTIVO" : "INACTIVO") + ";");
			sb.append(v.getCareer() + ";");
			sb.append(v.getTime() + ";");
			sb.append(v.getOrigin() + ";");
			if (v instanceof AdministradorDTO) {
				AdministradorDTO aux = (AdministradorDTO) v;
				sb.append(formato.format(v.getRegistrationdate()) + ";");
				sb.append(aux.getPassword() + "\n");
			} else {
				sb.append(formato.format(v.getRegistrationdate()) + "\n");
			}
		}
		FileHandler.escribirArchivoDeTexto("datosEst.csv", sb.toString());
		FileHandler.escribirSerializado("datosEst.dat", lista);
	}

}
