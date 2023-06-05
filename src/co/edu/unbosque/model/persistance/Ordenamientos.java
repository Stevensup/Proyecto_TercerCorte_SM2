/**
 * Esta clase es la encargada de realizar los ordenamientos y filtrados
 * de la información de los estudiantes.
 */

package co.edu.unbosque.model.persistance;

import java.util.ArrayList;

import java.util.Arrays;

import co.edu.unbosque.model.UsuarioDTO;
/**
 * 
 * @author Codernautas
 *
 */
public class Ordenamientos {
	
	/**
	 * Este método emplea el ordenamiento recursivo quickSort para ordenar
	 * los nombres de los estudiantes de forma ascendente y descendente.
	 * El orden ha sido seleccionados por el usuario.
	 * La lista de UsuarioDTO está inicializada(no es null).
	 *  Se ha ordenado la información.
	 * @param orden Es el orden que elige el usuario, bien sea ascendente o
	 * descendente.
	 * @param arr Es la lista de UsuarioDTO.
	 * @param izq Es la posición de la lista para realizar la comparación. 
	 * @param der Es la posición de la lista para realizar la comparación.
	 * @return ArrayList<UsuarioDTO> retorna la lista de estudiantes ordenada
	 * según el nombre.
	 */

	public static ArrayList<UsuarioDTO> quickSort(boolean orden, ArrayList<UsuarioDTO> arr, int izq, int der) {

		if (orden == true) {

			if (izq >= der) {
				return arr;
			}
			int i = izq;
			int d = der;

			if (izq != der) {
				int pivote;
				UsuarioDTO aux;

				pivote = izq;
				while (izq != der) {
					while (arr.get(der).getName().compareTo(arr.get(pivote).getName()) >= 0 && izq < der) {
						der--;
					}

					while (arr.get(izq).getName().compareTo(arr.get(pivote).getName()) < 0 && izq < der) {
						izq++;
					}
					if (der != izq) {
						aux = arr.get(der);
						arr.set(der, arr.get(izq));
						arr.set(izq, aux);
					}

				}
				if (izq == der) {
					quickSort(orden, arr, i, izq - 1);
					quickSort(orden, arr, izq + 1, d);
				}

			} else {
				return arr;
			}

			return arr;
		} else if (orden == false) {
			if (izq >= der) {
				return arr;
			}
			int i = izq;
			int d = der;

			if (izq != der) {
				int pivote;
				UsuarioDTO aux;

				pivote = izq;
				while (izq != der) {
					while (arr.get(der).getName().compareTo(arr.get(pivote).getName()) <= 0 && izq < der) {
						der--;
					}

					while (arr.get(izq).getName().compareTo(arr.get(pivote).getName()) > 0 && izq < der) {
						izq++;
					}
					if (der != izq) {
						aux = arr.get(der);
						arr.set(der, arr.get(izq));
						arr.set(izq, aux);
					}

				}
				if (izq == der) {
					quickSort(orden, arr, i, izq - 1);
					quickSort(orden, arr, izq + 1, d);
				}

				
			} else {
				return arr;
			}

			return arr;
		}
		return arr;
	}
	
	/**
	 * Este método emplea el ordenamiento recursivo quickSort para ordenar
	 * los apellidos de los estudiantes de forma ascendente y descendente.
	 * El orden ha sido seleccionados por el usuario.
	 * La lista de UsuarioDTO está inicializada(no es null).
	 *  Se ha ordenado la información.
	 * @param orden Es el orden que elige el usuario, bien sea ascendente o
	 * descendente.
	 * @param arr Es la lista de UsuarioDTO.
	 * @param izq Es la posición de la lista para realizar la comparación. 
	 * @param der Es la posición de la lista para realizar la comparación.
	 * @return ArrayList<UsuarioDTO> retorna la lista de estudiantes ordenada
	 * según el apellido.
	 */

	public static ArrayList<UsuarioDTO> quickSort2(boolean orden, ArrayList<UsuarioDTO> arr, int izq, int der) {

		if (orden == true) {

			if (izq >= der) {
				return arr;
			}
			int i = izq;
			int d = der;

			if (izq != der) {
				int pivote;
				UsuarioDTO aux;

				pivote = izq;
				while (izq != der) {
					while (arr.get(der).getLastname().compareTo(arr.get(pivote).getLastname()) >= 0 && izq < der) {
						der--;
					}

					while (arr.get(izq).getLastname().compareTo(arr.get(pivote).getLastname()) < 0 && izq < der) {
						izq++;
					}
					if (der != izq) {
						aux = arr.get(der);
						arr.set(der, arr.get(izq));
						arr.set(izq, aux);
					}

				}
				if (izq == der) {
					quickSort2(orden, arr, i, izq - 1);
					quickSort2(orden, arr, izq + 1, d);
				}

			} else {
				return arr;
			}

			return arr;
		} else if (orden == false) {
			if (izq >= der) {
				return arr;
			}
			int i = izq;
			int d = der;

			if (izq != der) {
				int pivote;
				UsuarioDTO aux;

				pivote = izq;
				while (izq != der) {
					while (arr.get(der).getLastname().compareTo(arr.get(pivote).getLastname()) <= 0 && izq < der) {
						der--;
					}

					while (arr.get(izq).getLastname().compareTo(arr.get(pivote).getLastname()) > 0 && izq < der) {
						izq++;
					}
					if (der != izq) {
						aux = arr.get(der);
						arr.set(der, arr.get(izq));
						arr.set(izq, aux);
					}

				}
				if (izq == der) {
					quickSort2(orden, arr, i, izq - 1);
					quickSort2(orden, arr, izq + 1, d);
				}

			} else {
				return arr;
			}

			return arr;
		}
		return arr;
	}
	
	/**
	 * Este método emplea el ordenamiento reiterativo bubbleSort para ordenar
	 * los usuarios de los estudiantes de forma descendente.
	 * El orden ha sido seleccionados por el usuario.
	 * La lista de UsuarioDTO está inicializada(no es null).
	 *  Se ha ordenado la información.
	 * @param orden Es el orden que elige el usuario.
	 * @param arr Es la lista de UsuarioDTO.
	 * @return ArrayList<UsuarioDTO> retorna la lista de estudiantes ordenada
	 * según su usuario.
	 */

	public static ArrayList<UsuarioDTO> bubbleSort(boolean orden, ArrayList<UsuarioDTO> arr) {
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.size() - 1; j++) {
				if (orden) {
					if (arr.get(j).getUser().compareTo(arr.get(j + 1).getUser()) > 0) {
						UsuarioDTO aux = arr.get(j);
						arr.set(j, arr.get(j + 1));
						arr.set(j + 1, aux);
					}
				} else {
					if (arr.get(j).getUser().compareTo(arr.get(j + 1).getUser()) < 0) {
						UsuarioDTO aux = arr.get(j);
						arr.set(j, arr.get(j + 1));
						arr.set(j + 1, aux);
					}
				}
			}
		}
		return arr;
	}
	
	/**
	 * Este método emplea el ordenamiento reiterativo bubbleSort para ordenar
	 * los id de los estudiantes de forma ascendente y descendente.
	 * El orden ha sido seleccionados por el usuario.
	 * La lista de UsuarioDTO está inicializada(no es null).
	 *  Se ha ordenado la información.
	 * @param orden Es el orden que elige el usuario.
	 * @param arr Es la lista de UsuarioDTO.
	 * @return ArrayList<UsuarioDTO> retorna la lista de estudiantes ordenada
	 * según su id.
	 */

	public static ArrayList<UsuarioDTO> bubbleSort2(boolean orden, ArrayList<UsuarioDTO> arr) {
		for (int i = 0; i < arr.size(); i++) {
			for (int j = 0; j < arr.size() - 1; j++) {
				long primero = Long.parseLong(arr.get(j).getId());
				long segundo = Long.parseLong(arr.get(j + 1).getId());
				if (orden) {
					if (primero > segundo) {
						UsuarioDTO aux = arr.get(j);
						arr.set(j, arr.get(j + 1));
						arr.set(j + 1, aux);
					}
				} else {
					if (primero < segundo) {
						UsuarioDTO aux = arr.get(j);
						arr.set(j, arr.get(j + 1));
						arr.set(j + 1, aux);
					}
				}
			}
		}
		return arr;
	}
	/**
	 * Este método emplea el ordenamiento recursivo shellSort para ordenar
	 * la información en el filtrado de estudiantes según su actividad o inactividad. 
	 * El orden ha sido seleccionados por el usuario.
	 * La lista de UsuarioDTO está inicializada(no es null).
	 *  Se ha ordenado la información de tal manera que se 
	 * relacione con un filtrado según la actividad o inactividad de los estudiantes.
	 * @param orden Es el orden que elige el usuario.
	 * @param arr Es la lista de UsuarioDTO.
	 * @return ArrayList<UsuarioDTO> retorna la lista de estudiantes ordenada
	 * según su actividad o inactividad.
	 */

	public static ArrayList<UsuarioDTO> shellSort(boolean orden, ArrayList<UsuarioDTO> arr) {
		if (orden) {
			for (int i = 1; i < arr.size(); i++) {
				UsuarioDTO aux = arr.get(i);
				int j = 0;
				for (j = i - 1; j >= 0
						&& String.valueOf(arr.get(j).isState()).compareTo(String.valueOf(aux.isState())) > 0; j--) {
					arr.set(j + 1, arr.get(j));
				}
				arr.set(j + 1, aux);
			}
		} else {
			for (int i = 1; i < arr.size(); i++) {
				UsuarioDTO aux = arr.get(i);
				int j = 0;
				for (j = i - 1; j >= 0
						&& String.valueOf(arr.get(j).isState()).compareTo(String.valueOf(aux.isState())) < 0; j--) {
					arr.set(j + 1, arr.get(j));
				}
				arr.set(j + 1, aux);
			}
		}
		return arr;
	}
	
	/**
	 * Este método se emplea para realizar la búsqueda de estudiantes ordenando 
	 * los datos encontrados en la primera parte de la lista.
	 * La lista de UsuarioDTO está inicializada(no es null).
	 *  Se ha ordenado la información de tal manera que se 
	 * relacione con la búsqueda registrada.
	 * @param item Es el item que elige el usuario.
	 * @param arr Es la lista de UsuarioDTO.
	 * @return ArrayList<UsuarioDTO> retorna la lista de estudiantes según la
	 * búsqueda realizada.
	 */


	public static ArrayList<UsuarioDTO> busqueda(String item, ArrayList<UsuarioDTO> arr) {
		ArrayList<UsuarioDTO> lis = new ArrayList<>();
		ArrayList<UsuarioDTO> aux = new ArrayList<>();
		for (UsuarioDTO usuario : arr) {
			if ((usuario.getName().equalsIgnoreCase(item)) || (usuario.getId().equalsIgnoreCase(item))
					|| (usuario.getLastname().equalsIgnoreCase(item)) || (usuario.getUser().equalsIgnoreCase(item))) {
				aux.add(usuario);
			} else {
				lis.add(usuario);
			}
		}

		arr.clear();
		arr.addAll(aux);
		arr.addAll(lis);

		return arr;

	}
	/**
	 * Este método se emplea para realizar el conteo de cada uno de los usuarios
	 * por carrera, esta información se agrega a un arreglo de strings, con el
	 * fin de ordenarlos de forma descendete según el número de usuarios.
	 * La lista de UsuarioDTO está inicializada(no es null).
	 *  Se han ordenado los strings de forma descendente según el 
	 * número de usuarios.
	 * @param lis Es la lista de UsuarioDTO.
	 * @return String[] retorna el arreglo de strings ordenado de forma descendente.
	 */


	public static String[] filtrar1(ArrayList<UsuarioDTO> lis) {
		int s = 0, a = 0, b = 0, e = 0, in = 0;
		for (UsuarioDTO user : lis) {
			if (user.getCareer().contains("Sistemas")) {
				s++;
			} else if (user.getCareer().contains("Ambiental")) {
				a++;
			} else if (user.getCareer().contains("Bioingenieria")) {
				b++;
			} else if (user.getCareer().contains("Electronica")) {
				e++;
			} else if (user.getCareer().contains("Industrial")) {
				in++;
			}
		}
		String[] res = { s + "s", a + "a", b + "b", e + "e", in + "in" };
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length - 1; j++) {
				if (res[j].compareTo(res[j + 1]) < 0) {
					String aux = res[j];
					res[j] = res[j + 1];
					res[j + 1] = aux;
				}
			}
		}
		String[] resultado = new String[5];
		for (int i = 0; i < res.length; i++) {
			if (res[i].contains("s")) {
				resultado[i] = "Sistemas";
			} else if (res[i].contains("a")) {
				resultado[i] = "Ambiental";
			} else if (res[i].contains("b")) {
				resultado[i] = "Bioingenieria";
			} else if (res[i].contains("e")) {
				resultado[i] = "Electronica";
			} else if (res[i].contains("in")) {
				resultado[i] = "Industrial";
			}
		}
		return resultado;
	}
	/**
	 * Este método se emplea para realizar el conteo de cada uno de los usuarios
	 * nacionales e internacionales por carrera según un archivo de texto que contiene
	 * el listado de los países, esta información se agrega a un arreglo de strings, con 
	 * el fin de ordenarlos de forma descendete según el número de usuarios nacionales e internacionales.
	 * La lista de UsuarioDTO está inicializada(no es null).
	 * Se han ordenado los strings de forma descendente según el 
	 * número de usuarios nacionales e internacionales segú la carrera.
	 * @param lis Es la lista de UsuarioDTO.
	 * @return String[] retorna el arreglo de strings ordenado de forma descendente.
	 */

	public static String[] filtrar2(ArrayList<UsuarioDTO> lis) {
		String contenido = FileHandler.abrirArchivoDeTexto("ComboBox/Pais.txt");
		String[] lineas = contenido.split("\n");
		int s = 0, s1 = 0;
		int a = 0, a1 = 0;
		int b = 0, b1 = 0;
		int e = 0, e1 = 0;
		int in = 0, in1 = 0;
		for (UsuarioDTO user : lis) {
			if (user.getCareer().contains("Sistemas")) {
				s1++;
				for (int i = 0; i < lineas.length; i++) {
					if (user.getOrigin().contains(lineas[i])) {
						s++;
						break;
					}
				}
			} else if (user.getCareer().contains("Ambiental")) {
				a1++;
				for (int i = 0; i < lineas.length; i++) {
					if (user.getOrigin().contains(lineas[i])) {
						a++;
						break;
					}
				}
			} else if (user.getCareer().contains("Bioingenieria")) {
				b++;
				for (int i = 0; i < lineas.length; i++) {
					if (user.getOrigin().contains(lineas[i])) {
						b++;
						break;
					}
				}
			} else if (user.getCareer().contains("Electronica")) {
				e1++;
				for (int i = 0; i < lineas.length; i++) {
					if (user.getOrigin().contains(lineas[i])) {
						e++;
						break;
					}
				}
			} else if (user.getCareer().contains("Industrial")) {
				in1++;
				for (int i = 0; i < lineas.length; i++) {
					if (user.getOrigin().contains(lineas[i])) {
						in++;
						break;
					}
				}
			}
		}
		s = s1 - s;
		a = a1 - a;
		b = b1 - b;
		e = e1 - e;
		in = in1 - in;
		String[] res = { s + "s", a + "a", b + "b", e + "e", in + "in" };
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length - 1; j++) {
				if (res[j].compareTo(res[j + 1]) < 0) {
					String aux = res[j];
					res[j] = res[j + 1];
					res[j + 1] = aux;
				}
			}
		}
		String[] resultado = new String[5];
		for (int i = 0; i < res.length; i++) {
			if (res[i].contains("s")) {
				resultado[i] = "Sistemas";
			} else if (res[i].contains("a")) {
				resultado[i] = "Ambiental";
			} else if (res[i].contains("b")) {
				resultado[i] = "Bioingenieria";
			} else if (res[i].contains("e")) {
				resultado[i] = "Electronica";
			} else if (res[i].contains("in")) {
				resultado[i] = "Industrial";
			}
		}
		return resultado;
	}

}