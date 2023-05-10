package co.edu.unbosque.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class OrdEstructuraDatos {

  private String[][] datos;

  public void ordenar(
    String[][] datos,
    String atributo,
    String orden,
    String algoritmo
  ) {
    // Copiamos la matriz original para no modificarla
    String[][] copiaDatos = Arrays.copyOf(datos, datos.length);

    // Ordenamos según el atributo seleccionado
    switch (atributo) {
      case "Nombre":
        Arrays.sort(copiaDatos, Comparator.comparing(e -> e[0]));
        break;
      case "Fecha de Creación":
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Arrays.sort(
          copiaDatos,
          (e1, e2) -> {
            try {
              Date date1 = formatter.parse(e1[1]);
              Date date2 = formatter.parse(e2[1]);
              return date1.compareTo(date2);
            } catch (ParseException ex) {
              throw new RuntimeException(ex);
            }
          }
        );
        break;
      case "Ventas del Mes":
        Arrays.sort(
          copiaDatos,
          Comparator.comparing(e -> Double.parseDouble(e[2]))
        );
        break;
      case "Número de Clientes":
        Arrays.sort(
          copiaDatos,
          Comparator.comparing(e -> Integer.parseInt(e[3]))
        );
        break;
      default:
        System.out.println("Atributo no válido");
        return;
    }

    // Ordenamos según el orden seleccionado
    if (orden.equals("Descendente")) {
      for (int i = 0; i < copiaDatos.length / 2; i++) {
        String[] temp = copiaDatos[i];
        copiaDatos[i] = copiaDatos[copiaDatos.length - 1 - i];
        copiaDatos[copiaDatos.length - 1 - i] = temp;
      }
    }

    // Aplicamos el algoritmo de ordenamiento seleccionado
    switch (algoritmo) {
      case "Burbuja":
        ordenarBurbuja(datos);
        break;
      case "Selección":
        ordenarSeleccion(datos, 0, true);
        break;
      case "Inserción":
        ordenarInsercion(datos);
        break;
      default:
        System.out.println("Algoritmo no válido");
        return;
    }

    // Guardamos los datos ordenados
    this.datos = datos;
  }

  private void ordenarBurbuja(String[][] arreglo) {
    for (int i = 0; i < arreglo.length - 1; i++) {
      for (int j = 0; j < arreglo.length - 1 - i; j++) {
        if (arreglo[j][0].compareTo(arreglo[j + 1][0]) > 0) {
          String[] temp = arreglo[j];
          arreglo[j] = arreglo[j + 1];
          arreglo[j + 1] = temp;
        }
      }
    }
  }

  private void ordenarSeleccion(
    String[][] arreglo,
    int columna,
    boolean ascendente
  ) {
    for (int i = 0; i < arreglo.length - 1; i++) {
      int indiceMenor = i;
      for (int j = i + 1; j < arreglo.length; j++) {
        if (
          comparar(
            arreglo[j][columna],
            arreglo[indiceMenor][columna],
            ascendente
          ) <
          0
        ) {
          indiceMenor = j;
        }
      }
      if (indiceMenor != i) {
        intercambiar(arreglo, i, indiceMenor);
      }
    }
  }

  private void ordenarInsercion(String[][] arreglo) {
    for (int i = 1; i < arreglo.length; i++) {
      String[] temp = arreglo[i];
      int j = i - 1;
      while (j >= 0 && arreglo[j][0].compareTo(temp[0]) > 0) {
        arreglo[j + 1] = arreglo[j];
        j--;
      }
      arreglo[j + 1] = temp;
    }
  }

  private void intercambiar(String[][] arreglo, int i, int j) {
    String[] temp = arreglo[i];
    arreglo[i] = arreglo[j];
    arreglo[j] = temp;
  }

  private int comparar(String a, String b, boolean ascendente) {
    int resultado = a.compareTo(b);
    if (!ascendente) {
      resultado *= -1;
    }
    return resultado;
  }

  private void mostrarMatriz(String[][] matriz) {
    for (String[] fila : matriz) {
      for (String dato : fila) {
        System.out.print(dato + "\t");
      }
      System.out.println();
    }
  }

public void ordenarDescendente(ArrayList<String> estructuraDatos) {
}

public void ordenarAscendente(ArrayList<String[]> estructuraDatos, int i) {
}

public void ordenarDescendente(ArrayList<String[]> estructuraDatos, int i) {
}
}
