package co.edu.unbosque.controller;

import co.edu.unbosque.view.VistaConsola;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Controller {

  private Scanner scanner;
  private VistaConsola vista;

  public Controller() {
    scanner = new Scanner(System.in);
    vista = new VistaConsola();
  }

  public void start() {
    // Configuración de las propiedades para la conexión SMTP de Gmail
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    // Credenciales de la cuenta de Gmail
    final String username = "tu_correo@gmail.com";
    final String password = "tu_contraseña";

    // Creación de la sesión de correo electrónico
    Session session = Session.getInstance(props);

    try {
      // Creación del mensaje de correo electrónico
      Message message = new MimeMessage(session);
      message.setFrom(new InternetAddress(username));
      message.setRecipients(
        Message.RecipientType.TO,
        InternetAddress.parse("destinatario@example.com")
      );
      message.setSubject("Asunto del correo");
      message.setText("Contenido del correo");

      // Autenticación y envío del mensaje
      Transport transport = session.getTransport("smtp");
      transport.connect("smtp.gmail.com", username, password);
      transport.sendMessage(message, message.getAllRecipients());
      transport.close();

      System.out.println("Correo electrónico enviado correctamente.");
    } catch (MessagingException e) {
      System.out.println(
        "Error al enviar el correo electrónico: " + e.getMessage()
      );
    }
  }
}
