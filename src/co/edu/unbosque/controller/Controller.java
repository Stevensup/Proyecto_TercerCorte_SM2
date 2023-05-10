package co.edu.unbosque.controller;

import co.edu.unbosque.model.OrdBurbuja;
import co.edu.unbosque.model.OrdEstructuraDatos;
import co.edu.unbosque.model.OrdInsercion;
import co.edu.unbosque.model.OrdSeleccion;
import co.edu.unbosque.view.VistaConsola;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Controller {

    private Scanner scanner;
    private VistaConsola vista;
    private OrdBurbuja OB;
    private OrdSeleccion OS;
    private OrdInsercion OI;
    private OrdEstructuraDatos OED;

	
    public Controller() {
        scanner = new Scanner(System.in);
        vista = new VistaConsola();
       OB = new OrdBurbuja();
       OI = new OrdInsercion(new String[]{"b", "f", "h", "a", "c", "d", "e", "g", "h", "i"});
       OED = new OrdEstructuraDatos();
       
    }

    
    public void start() {
        int option = 0;
        do {
            vista.mostrarInformacion("-------------------Escoge una opcion:");
            vista.mostrarInformacion("-------------------1. Ordenamiento Burbuja ");
            vista.mostrarInformacion("-------------------2. Ordenamiento Selección");
            vista.mostrarInformacion("-------------------3. Ordenamiento Inserción");
            vista.mostrarInformacion("-------------------4. Ordenar una Estructura de Datos");
            vista.mostrarInformacion("-------------------5. Reflexión");
            vista.mostrarInformacion("-------------------6. Salir");
            System.out.print("-------------------Ingrese la opcion: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                vista.mostrarInformacion("Ordenamiento Burbuja");
            
                int[] arreglo = {-32, 45, -2, 0, 4, 32 ,2 ,1 ,100, -100};
                vista.mostrarInformacion("Arreglo desordenado: " + Arrays.toString(arreglo));
            
                OrdBurbuja burbuja = new OrdBurbuja();
                burbuja.ordenarAsc(arreglo);
                vista.mostrarInformacion("Arreglo ordenado ascendentemente: " + Arrays.toString(arreglo));
                
                burbuja.ordenarDesc(arreglo);
                vista.mostrarInformacion("Arreglo ordenado descendentemente: " + Arrays.toString(arreglo));
                
                break;   
                    case 2:
                    vista.mostrarInformacion("Ordenamiento Selección");

                        String[] nombres = {
                            "FEIJOO GARCIA MIGUEL ALFONSO",
                            "RAMIREZ AREVALO HELIO",
                            "RODRIGUEZ PINTO JAIRO ESTEBAN",
                            "ROJAS MARTINEZ JUAN JOSE",
                            "SIERRA ARDILA DIEGO ALEJANDRO",
                            "PEREZ TORRES DIANA MARCELA",
                            "PARRA GARCIA MARIA",
                            "GONZALEZ AREVALO RAMIRO",
                            "ARIAS FERNANDEZ ANGELICA SOFIA",
                            "CAMARGO LOPEZ CARLOS JULIO"
                        };

                        OrdSeleccion seleccion = new OrdSeleccion();
                        seleccion.ordenar(nombres);

                        vista.mostrarInformacion("Nombres ordenados ascendentemente: " + Arrays.toString(seleccion.getArregloOrdenadoAscendente()));
                        vista.mostrarInformacion("Nombres ordenados descendentemente: " + Arrays.toString(seleccion.getArregloOrdenadoDescendente()));
                        break;
                

                    case 3:
                    String[] arregloInsercion = {"b", "f", "h", "a", "c", "d", "e", "g", "h", "i"};
                    OI = new OrdInsercion(arregloInsercion);
                
                    // Mostrar arreglo SIN ordenar
                    vista.mostrarInformacion("Arreglo SIN ordenar: " + Arrays.toString(arregloInsercion));
                
                    // Ordenar arreglo ASCENDENTEMENTE
                    OI.ordenarAscendente();
                
                    // Mostrar arreglo ordenado ASCENDENTEMENTE
                    vista.mostrarInformacion("Arreglo Ordenado ASCENDENTEMENTE: " + Arrays.toString(arregloInsercion));
                
                    // Ordenar arreglo DESCENDENTEMENTE
                    OI.ordenarDescendente();
                
                    // Mostrar arreglo ordenado DESCENDENTEMENTE
                    vista.mostrarInformacion("Arreglo Ordenado DESCENDENTEMENTE: " + Arrays.toString(arregloInsercion));
                    break;
                
                    case 4:

                    String[][] datos = {
                        {"Nombre", "Fecha de Creación", "Ventas del Mes", "Número de Clientes"},
                        {"Textiles LuisP", "20/03/2008", "37.456.000", "342"},
                        {"Comidas Rápidas: ¡Qué Alitas!", "25/12/2018", "62.876.000", "2347"},
                        {"Panadería DKCH", "14/04/2015", "123.345.000", "5654"},
                        {"Zapatería Donde Mercedes", "17/03/2000", "12.500.000", "398"},
                        {"Supermercado San Juan", "10/06/1999", "92.889.000", "2654"}
                    };
                    vista.mostrarInformacion("Ordenar una Estructura de Datos");
                    
                    // Crear la estructura de datos a partir de los elementos de la matriz
                    ArrayList<String[]> estructuraDatos = new ArrayList<String[]>(Arrays.asList(datos));
                    
                    // Mostrar la estructura de datos SIN ordenar
                    vista.mostrarInformacion("Estructura de datos SIN ordenar: " + estructuraDatos.toString());
                    
                    // Ordenar la estructura de datos ASCENDENTEMENTE por el nombre
                    OED.ordenarAscendente(estructuraDatos, 0);
                    
                    // Mostrar la estructura de datos ordenada ASCENDENTEMENTE
                    vista.mostrarInformacion("Estructura de datos ordenada ASCENDENTEMENTE por el nombre: " + estructuraDatos.toString());
                    
                    // Ordenar la estructura de datos DESCENDENTEMENTE por las ventas del mes
                    OED.ordenarDescendente(estructuraDatos, 2);
                    
                    // Mostrar la estructura de datos ordenada DESCENDENTEMENTE
                    vista.mostrarInformacion("Estructura de datos ordenada DESCENDENTEMENTE por las ventas del mes: " + estructuraDatos.toString());
                    break;

                
                    case 5:
                       
                    break;
                case 6:
                    vista.mostrarInformacion("Hasta pronto...");
                    break;
                default:
                    vista.mostrarInformacion("Opcion invalida...");
                    break;
            }
    
        } while (option != 6);
    }
}


