package co.edu.unbosque.controller;

import co.edu.unbosque.view.VistaConsola;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Controller {

  private Scanner scanner;
  private VistaConsola vista;

  public Controller() {
    scanner = new Scanner(System.in);
    vista = new VistaConsola();
  }

  public void start() {
  }
}
