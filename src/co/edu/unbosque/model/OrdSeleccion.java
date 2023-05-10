package co.edu.unbosque.model;

import java.util.Arrays;

public class OrdSeleccion {
    private String[] arregloOrdenadoAscendente;
    private String[] arregloOrdenadoDescendente;

    public void ordenar(String[] elementos) {
        // Copiamos el arreglo original para no modificarlo
        String[] copiaElementos = Arrays.copyOf(elementos, elementos.length);

        // Ordenamos de forma ascendente
        for (int i = 0; i < copiaElementos.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < copiaElementos.length; j++) {
                if (copiaElementos[j].compareTo(copiaElementos[indiceMenor]) < 0) {
                    indiceMenor = j;
                }
            }
            if (indiceMenor != i) {
                String temp = copiaElementos[i];
                copiaElementos[i] = copiaElementos[indiceMenor];
                copiaElementos[indiceMenor] = temp;
            }
        }

        // Guardamos el arreglo ordenado ascendentemente
        arregloOrdenadoAscendente = copiaElementos;

        // Creamos una copia del arreglo ordenado ascendentemente para ordenarlo descendentemente
        String[] copiaArregloOrdenadoAscendente = Arrays.copyOf(arregloOrdenadoAscendente, arregloOrdenadoAscendente.length);

        // Ordenamos de forma descendente
        for (int i = 0; i < copiaArregloOrdenadoAscendente.length / 2; i++) {
            String temp = copiaArregloOrdenadoAscendente[i];
            copiaArregloOrdenadoAscendente[i] = copiaArregloOrdenadoAscendente[copiaArregloOrdenadoAscendente.length - 1 - i];
            copiaArregloOrdenadoAscendente[copiaArregloOrdenadoAscendente.length - 1 - i] = temp;
        }

        // Guardamos el arreglo ordenado descendentemente
        arregloOrdenadoDescendente = copiaArregloOrdenadoAscendente;
    }

    public String[] getArregloOrdenadoAscendente() {
        return arregloOrdenadoAscendente;
    }

    public String[] getArregloOrdenadoDescendente() {
        return arregloOrdenadoDescendente;
    }
}
