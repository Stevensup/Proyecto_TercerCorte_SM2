package co.edu.unbosque.model;


public class OrdInsercion {

    private String[] arregloInsercion;

    public OrdInsercion(String[] arregloInsercion) {
        this.arregloInsercion = arregloInsercion;
    }

    public OrdInsercion() {
    }

    public void ordenarAscendente() {
        for (int i = 1; i < arregloInsercion.length; i++) {
            String elementoActual = arregloInsercion[i];
            int j = i - 1;
            while (j >= 0 && arregloInsercion[j].compareTo(elementoActual) > 0) {
                arregloInsercion[j + 1] = arregloInsercion[j];
                j--;
            }
            arregloInsercion[j + 1] = elementoActual;
        }
    }

    public void ordenarDescendente() {
        for (int i = 1; i < arregloInsercion.length; i++) {
            String elementoActual = arregloInsercion[i];
            int j = i - 1;
            while (j >= 0 && arregloInsercion[j].compareTo(elementoActual) < 0) {
                arregloInsercion[j + 1] = arregloInsercion[j];
                j--;
            }
            arregloInsercion[j + 1] = elementoActual;
        }
    }

    public void imprimirArreglo() {
        for (String elemento : arregloInsercion) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }
}
